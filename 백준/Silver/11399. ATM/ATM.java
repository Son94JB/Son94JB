import java.io.*;
import java.util.*;

public class Main {

    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력은 첫째 줄에 총 인원
        // 둘째 줄에 각 사람이 걸리는 시간
        // 누적합 구하기
        int n = Integer.parseInt(br.readLine());
        String[] timeStr = br.readLine().split(" ");
        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(timeStr[i]);
        }

        Arrays.sort(time);

        int[] prefixSum = new int[n];
        prefixSum[0] = time[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + time[i];
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += prefixSum[i];
        }
        
        System.out.println(sum);
    }
}