package com.aca.homework.week15.repository.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class EmployeeRepository implements CrudRepository<Employee, String> {

    private final ConnectionFactory connectionFactory;

    public EmployeeRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    public static void main(String[] args) {
        EmployeeRepository employeeRepository = new EmployeeRepository(new ConnectionFactory());
        employeeRepository.findAll();

    }

    @Override
    public void save(Employee employee) {
        Connection connection = connectionFactory.getObject();
        try(connection) {
            connection.createStatement().execute(
                    String.format("insert into employees (id, first_name, second_name, salary) values ('%s', '%s', '%s', %s);",
                            employee.getId(), employee.getFirstName(), employee.getSecondName(), employee.getSalary())
            );
        } catch (SQLException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(String.format("Could not insert employee %s into the database", employee.toString()));
        }
    }

    @Override
    public List<Employee> findAll() {
        Connection connection = connectionFactory.getObject();
        ResultSet resultSet = getResultSet(connection);

        List<Employee> employeeList = new LinkedList<>();

        while (true) {
            try(connection) {
                if (!resultSet.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }

            employeeList.add(new Employee(
                    getId(connection, resultSet),
                    getFirstName(connection, resultSet),
                    getSecondName(connection, resultSet),
                    getSalary(connection, resultSet)
            ));
        }
        if (employeeList.size() == 0)
            return Collections.emptyList();
        return Collections.unmodifiableList(employeeList);
    }

    @Override
    public Employee findById(String id) {
        Objects.requireNonNull(id);
        Connection connection = connectionFactory.getObject();
        ResultSet resultSet = getResultSet(connection);
        boolean resultSetIsFull = false;
        try(connection) {
            resultSetIsFull = resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(!resultSetIsFull) return null;
        return new Employee(
                id,
                getFirstName(connection, resultSet),
                getSecondName(connection, resultSet),
                getSalary(connection, resultSet)
        );
    }

    @Override
    public void deleteAll() {
        Connection connection = connectionFactory.getObject();
        try(connection) {
            connection.createStatement().execute("delete from employees;");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not delete all the data from employees table.");
        }
    }

    private String getId(Connection connection, ResultSet res) {
        try(connection) {
            return res.getString("id");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No column labelled as 'id'");
        }
    }

    private String getFirstName(Connection connection, ResultSet res) {
        try(connection) {
            return res.getString("first_name");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No column labelled as 'first_name'");
        }
    }

    private String getSecondName(Connection connection,ResultSet res) {
        try(connection) {
            return res.getString("second_name");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No column labelled as 'second_name'");
        }
    }

    private long getSalary(Connection connection, ResultSet res) {
        try(connection) {
            return res.getLong("salary");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("No column labelled as 'salary'");
        }
    }

    private ResultSet getResultSet(Connection connection) {
        try(connection) {
            return connection.createStatement().executeQuery("select * from employees;");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not select all the rows from table employees");
        }
    }
}
