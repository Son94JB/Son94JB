import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 각 반의 점수가 주어질 때, 각 반의 최대, 최소, 가장 큰 인접한 점수끼리의 차를 구하라.
        // 입력값은 첫째 줄에는 반의 수 K, 다음 줄에는 학생 수와 각 학생의 점수가 입력
        // 출력으로 Class X의 형태로 X는 반 번호.
        // 다음 줄에 Max xx, Min yy, Largest gap zz 이런 형태로 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            String[] scores = br.readLine().split(" ");
            int N = Integer.parseInt(scores[0]);
            int[] score = new int[scores.length - 1];
            for (int j = 0; j < scores.length - 1; j++) {
                score[j] = Integer.parseInt(scores[j + 1]);
            }

            Arrays.sort(score);

            for (int j = 0, k = score.length - 1; j < k; j++, k--) {
                int temp = score[j];
                score[j] = score[k];
                score[k] = temp;
            }

            int max = score[0];
            int min = score[N - 1];
            int lg = LargestGap(score);

            System.out.println("Class " + (i + 1));
            System.out.println("Max " + max + ", Min " + min + ", Largest gap " + lg);

        }
    }

    public static int LargestGap(int[] arr) {
        int lg = -1;
        int[] temp = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i] - arr[i + 1];
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > lg) lg = temp[i];
        }

        return lg;
    }
}