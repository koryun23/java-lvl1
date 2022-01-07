package homework2;

public class Ex1 {
    public static void main(String[] args){
        isWeird(6);
        isWeird(24);
    }
    public static void isWeird(int n){
        if((n%2==1) || (n%2 == 0 && n>=6 && n<=20)){
            System.out.println("Weird");
        }else if(n%2==0 && ((n>=2 && n<=5) || n > 20)){
            System.out.println("Not Weird");
        }
    }
}
