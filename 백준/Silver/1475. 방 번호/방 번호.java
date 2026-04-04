import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] roomNumber = br.readLine().split("");

        // 각 숫자가 몇 번 등장하는지 카운트
        int[] count = new int[10];
        for (String s : roomNumber) {
            count[Integer.parseInt(s)]++;
        }

        // 6과 9는 서로 대체 가능하므로 합산
        int sixNine = count[6] + count[9];

        int sets = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 6 || i == 9) continue; // 나중에 따로 처리
            sets = Math.max(sets, count[i]); // 1세트당 각 숫자 1개
        }

        // 6,9 합산 개수를 2로 나누어 올림 (한 세트에 6 하나, 9 하나)
        sets = Math.max(sets, (int) Math.ceil(sixNine / 2.0));

        System.out.println(sets);
    }
}