package classwork4;

import java.util.Arrays;

public class ReferenceTest {
    public static void main(String[] args) {
        int a = 7;
        int b = 8;
        swap(a, b);
        System.out.println(a);
        System.out.println(b);
        // will not be swapped
    }
    public static void swap(int a, int b){
        int c = a;
        a = b;
        b = c;
        System.out.println(a); // will be swapped
        System.out.println(b); // will not be swapped
    }
    public static void testSwapReferences(){
        int[] array1 = {1, 2, 3, 0};
        int[] array2 = {72, 333, 0, 77};
        swapArray(array1, array2);
        System.out.println(array1[0]);
        System.out.println(array2[0]);
    }
    public static void swapArray(int[] i, int[] j){
        int[] t = i;
        i=j;
        j=t;
    }
    public static void makeReferenceNull(){
        int[] array = new int[4];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        deleteReference(array);
        System.out.println(Arrays.toString(array));
    }
    public static void deleteReference(int[] i){
        i = null;
    }
    public static void testArray(){
        int[] array = {0,1,2,3,4};
        changeArray(array);
        System.out.println(Arrays.toString(array));
    }
    public static void changeArray(int[] i){
        i[1] = 2342;
    }
    public static void testInt(){
        int i = 5;
        int j = increment(i);
        System.out.println(i);
    }
    public static int increment(int i){
        i+=5;
        return i;
    }
}
