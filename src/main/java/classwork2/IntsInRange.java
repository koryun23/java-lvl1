package classwork2;

import java.util.Arrays;

public class IntsInRange {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i;
        }


        System.out.println(toString(arr));
        System.out.println(sum(arr));
        printArray(new int[30]);
    }

    public static int sum(int[] arr){
        int sum = 0;
        for (int i : arr){
            sum+=i;

        }
        return sum;
    }

    public static String toString(int[] arr){
        String output = "[";
        for (int i = 0; i < arr.length; i++){
            output+=arr[i];
            if(i != arr.length-1){
                output+=", ";
            }else{
                output+="]";
            }

        }
        return output;
    }

    public static void printArray(int[] arr){
        for(int i = 0; i< arr.length; i++){
            System.out.format("array[%d] = %d\n", i, i/10);
        }
    }
}
