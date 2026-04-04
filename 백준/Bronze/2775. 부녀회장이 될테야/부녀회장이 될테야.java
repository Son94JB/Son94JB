import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // a층 b호에 살면 (a-1)층 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야한다.
        // 비어있는 집은 없고 모두 이 조건에 충족한다고할 때
        // k, n에 대해 k층 n호에는 몇 명이 살고 있는지 출력
        // 아파트는 0층부터 있고 각층은 1호부터 있다. 0층의 i호에는 i명이 산다.
        // 1 <= k, n <= 14

        // 입력값은 첫 줄에는 T, 다음 줄부터는 k와 n이 각각의 줄로 T번 주어진다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(calculate(k, n));
        }
    }

    public static int calculate(int k, int n) {
        int[] zeroFloor = new int[15];
        for (int i = 0; i < 15; i++) {
            zeroFloor[i] = i + 1;
        }

        int[][] floor = new int[15][15];

        floor[0] = zeroFloor;
        for (int i = 1; i < 15; i++) {
            floor[i][0] = floor[i - 1][0];
            for (int j = 1; j < 15; j++) {
                floor[i][j] = floor[i][j - 1] + floor[i - 1][j];
            }
        }
        return floor[k][n-1];
    }
}