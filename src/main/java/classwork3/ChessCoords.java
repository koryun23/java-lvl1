package classwork3;

import java.util.Arrays;

public class ChessCoords {
    public static void main(String[] args) {
        String coord = "e-4";
        System.out.println(Arrays.toString(getCoordsInNumbers(coord)));
    }
    public static int[] getCoordsInNumbers(String coord){
        char col = coord.charAt(0);
        char row = coord.charAt(coord.length()-1);
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        int colNumber = 0;
        for(int i = 0; i < letters.length; i++){
            if (letters[i] == col){
                colNumber = i;
                break;
            }
        }
        return new int[]{colNumber, Integer.parseInt(row+"")-1};
    }
}
