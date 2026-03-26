import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 피보나치 수열에서 0과 1이 몇 번이나 나오는지 리턴
        // 입력 받기(테스트 케이스 수(<40), 구하는 피보나치 수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int tc = Integer.parseInt(br.readLine());
            int a = fibonacci(tc)[0];
            int b = fibonacci(tc)[1];
            System.out.println(a + " " + b);
        }
    }

    static int[] fibonacci(int n) {

        // 0 개수
        int[] dp1 = new int[41];
        dp1[0] = 1;
        dp1[1] = 0;
        for (int i = 2; i <= 40; i++) {
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }

        // 1 개수
        int[] dp2 = new int[41];
        dp2[0] = 0;
        dp2[1] = 1;
        for (int i = 2; i <= 40; i++) {
            dp2[i] = dp2[i - 1] + dp2[i - 2];
        }
        return new int[]{dp1[n], dp2[n]};
    }

}