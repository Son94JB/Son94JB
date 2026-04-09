import java.io.*;
import java.util.*;

public class Main {
    public static int[][] square;

    public static void main(String[] args) throws IOException {
        // N x M 크기의 직사각형이 있다.
        // 꼭지점의 각 수가 모두 같은, 가장 큰 정사각형을 찾기
        // 입력으로 N, M이 주어지고 다음 줄 부터 N개의 줄에 숫자가 주어진다.
        // 조건에 맞는 정사각형의 크기를 출력
        // 단, N, M은 50보다 같거나 작은 자연수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 직사각형 제작
        square = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                square[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 어차피 50 이하니까 완전탐색?
        // 한 변의 최대 길이
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int possibleMax = Math.min(n - i, m - j);

                // 이미 저장된 최대 길이가 현재 위치의 최대 가능 크기보다 크면 skip
                if (maxLen >= possibleMax) continue;

                for (int len = 2; len <= possibleMax; len++) {
                    // 꼭지점 수가 같은 정사각형 생성 되는지 확인
                    int point = square[i][j];
                    if (square[i][j + len - 1] == point &&
                            square[i + len - 1][j] == point &&
                            square[i + len - 1][j + len - 1] == point) {
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }
        }

        // 구한게 한 변의 길이니까 제곱해서 넓이 구하기
        System.out.println(maxLen*maxLen);

    }
}