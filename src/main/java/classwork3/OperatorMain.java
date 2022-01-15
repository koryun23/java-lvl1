package classwork3;

public class OperatorMain {
    public static void main(String[] args) {
        boolean c1 = (condition1() || condition2());
        boolean c2 = (condition3());
        if(c1 && c2){
            System.out.println("text1");
        }
    }
    public static boolean condition1(){
        return true;
    }
    public static boolean condition2(){
        return false;
    }
    public static boolean condition3(){
        return false;
    }
}
