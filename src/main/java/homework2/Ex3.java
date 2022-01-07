package homework2;

public class Ex3 {
    public static void main(String[] args) {
        quadraticEq(1, 5, 1);
    }
    public static void quadraticEq(int a, int b, int c){
        double squareRootD = Math.sqrt(b*b-4*a*c);
        double x1 = (-b+squareRootD)/(2*a);
        double x2 = (-b-squareRootD)/(2*a);
        System.out.println("The roots are "+ x1 +" and "+ x2);
    }
}
