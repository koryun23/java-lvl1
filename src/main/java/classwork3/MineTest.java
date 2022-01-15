package classwork3;

import java.util.Scanner;

public class MineTest {
    public static void main(String[] args) {
        char[] arr = new char[6];
        putMine(arr);
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter an index which you think is empty of mines: ");
            int index = scanner.nextInt();
            if(isThereAMineAt(arr, index)){
                System.out.println("There is a mine there.");
            }else{
                System.out.println("There is no mine there.");
            }

        }
    }
    public static boolean isThereAMineAt(char[] arr, int index){
        return arr[index] == '*';

    }
    public static void putMine(char[] arr){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < arr.length; i++){
            System.out.format("Do you want to put a mine at index %d? y/n\n", i);
            String answer = scanner.next();
            if (answer.equals("y")){
                arr[i] = '*'; // put a mine
            }
        }
    }
}
