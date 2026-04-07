import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 정수 N과 K가 주어질 때 이항계수를 구하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(BinomialCoefficient(N, K));
    }

    public static long BinomialCoefficient(int n, int k) {
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[n][k];
    }
}