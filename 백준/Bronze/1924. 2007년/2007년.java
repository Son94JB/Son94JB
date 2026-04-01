import java.io.*;
import java.util.*;

public class Main {
    public static String Days(int n) {
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        return days[n];
    }

    public static void main(String[] args) throws IOException {
        // 2007년 1월 1일은 월요일이다.
        // 입력으로 x, y가 주어질 때,
        // 2007년 x월 y일은 무슨 요일인가
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bufferedReader.readLine().split(" ");

        int x =  Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);

        int[] monthOffset = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};

        int totalDays = monthOffset[x - 1] + (y - 1);

        System.out.println(Days((1+totalDays)%7));

    }
}