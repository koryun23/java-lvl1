package classwork3;

import java.util.Arrays;

public class StringTest {
    public static void main(String[] args) {
        String s = "1|2|3|4|5|6hfgkfjhkljh0";
        StringBuilder sb = new StringBuilder();
        char[] nums = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i = 0; i<s.length(); i++){
            for (int j = 0; j < nums.length; j++){
                if (nums[j] == s.charAt(i)) {
                    sb.append(nums[j]);
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }


}
