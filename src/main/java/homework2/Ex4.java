package homework2;

public class Ex4 {
    public static void main(String[] args) {
        describeNumber(-2_000_000);
    }
    public static void describeNumber(double n){
        String output = "";
        if(n==0){
            output = "Zero";
        }else if(n > 0){
            output += "Positive ";
        }else{
            output+="Negative ";
        }
        if(Math.abs(n) < 1 && Math.abs(n) > 0){
            output += "small ";
        }else if(Math.abs(n) > 1_000_000){
            output += "large ";
        }
        output+="number";
        System.out.println(output);
    }
}
