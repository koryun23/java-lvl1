package homework2;

public class Ex2 {
    public static void main(String[] args) {
        multiples(2);
    }
    public static void multiples(int n){
        for(int i = 1; i<= 10;i++){
            System.out.format("%d x %d = %d\n", n, i, n*i);
        }
    }
}
