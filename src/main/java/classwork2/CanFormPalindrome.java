package classwork2;

import java.util.HashMap;
import java.util.Map;

public class CanFormPalindrome {
    public static void main(String[] args){
        System.out.println(canFormPalindrome("aabb"));
    }
    public static boolean canFormPalindrome(String s){
        int[] arr = new int[97];
        for (int i = 0; i<s.length();i++){
            arr[s.charAt(i)-97]++;
        }
        int countOdds = 0;
        for (int i = 0; i<arr.length; i++){
            if(arr[i]%2==1){
                countOdds++;
            }
        }
        return countOdds<=1;
    }
    public static boolean canFormPalindrome2(String s){
        HashMap<Character, Integer> met= new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(met.containsKey(s.charAt(i))){
                met.put(s.charAt(i), met.get(s.charAt(i))+1);
            }else{
                met.put(s.charAt(i), 1);
            }
        }
        int countOfOdds = 0;
        for (Map.Entry key : met.entrySet()){
            if ((int) key.getValue() % 2 == 1){
                countOfOdds+=1;
                if (countOfOdds > 1){
                    return false;
                }
            }
        }
        return true;
    }
}
