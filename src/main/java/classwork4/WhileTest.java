package classwork4;

public class WhileTest {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        long startTime = System.currentTimeMillis();
        long lastTime = startTime;

        while (true){
            String second = "";
            String minute = "";
            String hour = "";
            long currentSeconds = (System.currentTimeMillis() - startTime)/1000;
            long currentMinute = currentSeconds/60;
            long currentHour = currentMinute/60;
            currentSeconds %= 60;
            currentMinute %= 60;
            if(currentSeconds >= 0 && currentSeconds <= 9){
                second+="0";
            }
            if(currentMinute >= 0 && currentMinute <= 9){
                minute+="0";
            }
            if(currentHour >= 0 && currentHour <= 9){
                hour+="0";
            }
            second+=currentSeconds;
            minute+=currentMinute;
            hour+=currentHour;
            if(currentSeconds != lastTime){
                lastTime = currentSeconds;
                System.out.println((hour+ ":" + minute + ":" + second));
            }
        }
    }
}
