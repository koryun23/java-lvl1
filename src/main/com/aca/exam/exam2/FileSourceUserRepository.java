package com.aca.exam.exam2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Repository
public class FileSourceUserRepository implements CrudRepository<User, String> {
    private static final CrudRepository<User, String> userRepository = new FileSourceUserRepository();

    private FileSourceUserRepository() {
    }

    public static CrudRepository<User, String> of() {
        return userRepository;
    }

    @Override
    public User findById(String id) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\exam\\exam2\\users.txt"));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] userParametersArray = currentLine.split(",");
            if (id.equals(userParametersArray[0])) {
                return new User(id, userParametersArray[1], userParametersArray[2]);
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() throws FileNotFoundException {
        List<User> users = new LinkedList<>();
        Scanner scanner = new Scanner(new File("C:\\Users\\Koryun\\Desktop\\java-lvl1\\src\\main\\com\\aca\\exam\\exam2\\users.txt"));
        scanner.nextLine();
        scanner.nextLine();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            String[] userParametersArray = currentLine.split(",");
            users.add(new User(userParametersArray[0], userParametersArray[1], userParametersArray[2]));
        }
        return users;
    }
}
