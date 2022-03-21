package com.aca.exam.exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceOrderRepository implements CrudRepository<Order, Integer> {
    private final CrudRepository<User, String> userRepository;

    public FileSourceOrderRepository(CrudRepository<User, String> userRepository) {
        this.userRepository = userRepository;
    }

    public User fetchUserByUsername(String username) throws FileNotFoundException {
        return userRepository.findById(username);
    }

    @Override
    public Order findById(Integer id) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\exam\\exam2\\orders.txt"));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] orderParametersArray = currentLine.split(",");
            if (Integer.parseInt(orderParametersArray[0]) == id) {
                return new Order(
                        id,
                        orderParametersArray[1],
                        Integer.parseInt(orderParametersArray[2]),
                        fetchUserByUsername(orderParametersArray[3])
                );
            }
        }
        return null;
    }

    @Override
    public List<Order> findAll() throws FileNotFoundException {
        List<Order> orders = new LinkedList<>();
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\exam\\exam2\\orders.txt"));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] orderParametersArray = currentLine.split(",");
            orders.add(new Order(
                    Integer.parseInt(orderParametersArray[0]),
                    orderParametersArray[1],
                    Integer.parseInt(orderParametersArray[2]),
                    fetchUserByUsername(orderParametersArray[3])
            ));
        }
        return orders;
    }

    public List<Order> findAllByUserId(String userId) throws FileNotFoundException {
        List<Order> orders = new LinkedList<>();
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\exam\\exam2\\orders.txt"));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] orderParametersArray = currentLine.split(",");
            if (orderParametersArray[3].equals(userId)) {
                orders.add(new Order(
                        Integer.parseInt(orderParametersArray[0]),
                        orderParametersArray[1],
                        Integer.parseInt(orderParametersArray[2]),
                        fetchUserByUsername(orderParametersArray[3])
                ));
            }
        }
        return orders;
    }
}
