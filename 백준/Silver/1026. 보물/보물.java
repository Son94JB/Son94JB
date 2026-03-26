import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // A수열을 조절하여 각 인덱스의 B와 곱했을 때 최소가 되는 수 리턴
        // 입력 받기(숫자 개수(배열 길이), A, B 수열)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] seriesA = br.readLine().split(" ");
        String[] seriesB = br.readLine().split(" ");

        Integer[] integersA = new Integer[n];
        Integer[] integersB = new Integer[n];

        for (int i = 0; i < n; i++) {
            integersA[i] = Integer.parseInt(seriesA[i]);
            integersB[i] = Integer.parseInt(seriesB[i]);
        }

        Arrays.sort(integersA, Collections.reverseOrder());
        Arrays.sort(integersB);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += integersA[i] * integersB[i];
        }
        System.out.println(sum);
    }
}