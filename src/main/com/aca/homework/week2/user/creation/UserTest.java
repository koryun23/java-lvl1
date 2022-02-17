package com.aca.homework.week2.user.creation;

public class UserTest {
    public static void main(String[] args) {
        User[] users = createUsers();
        for(User user : users){
            printUser(user);
        }
    }

    public static User[] createUsers(){
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.name = "Marry";
        user1.height = 170;
        user2.name = "Grace";
        user2.height = 169;
        user3.name = "Nicolas";
        user3.height = 175;
        return new User[]{user1, user2, user3};
    }
    public static void printUser(User user){
        String apostrophe = "'";
        if (user.name.charAt(user.name.length()-1) != 's'){
            apostrophe = "'s";
        }
        System.out.format("The user is: %s, %s%s height is %f\n", user.name, user.name,apostrophe, user.height);
    }
}
