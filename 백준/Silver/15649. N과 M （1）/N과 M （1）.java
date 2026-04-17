import java.io.*;
import java.util.*;

public class Main {

    public static List<Integer> pick = new ArrayList<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // 입력으로 N과 M이 주어질 때
        // 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = i + 1;
        }

        int[] visited = new int[N];
        choice(numbers, M, visited, pick);
        System.out.println(sb);
    }

    public static void choice(int[] nums, int m, int[] v, List<Integer> pick) {
        // pick이 다 찼으면 출력에 추가
        if (pick.size() == m) {
            for (int num : pick) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        // for문으로 선택 방문
        for (int i = 0; i < nums.length; i++) {
            if (v[i] != 1) {
                pick.add(nums[i]);   // 선택
                v[i] = 1;            // 방문 표시

                choice(nums, m, v, pick);

                // 리셋
                pick.remove(pick.size() - 1);
                v[i] = 0;
            }
        }
    }
}