package homework2;

import java.util.Scanner;

public class Ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.length()>1){
            System.out.println("Invalid input");
        }else{
            char ch = input.charAt(0);
            if (!(ch >= 65 && ch <= 90) && !(ch >=97 && ch <=122)){
                System.out.println("Invalid input");
            }else{
                vowelOrConsonant(ch);
            }
        }
    }
    public static void vowelOrConsonant(char letter){
        if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
            System.out.println("Vowel");
        }else{
            System.out.println("Consonant");
        }
    }
}
