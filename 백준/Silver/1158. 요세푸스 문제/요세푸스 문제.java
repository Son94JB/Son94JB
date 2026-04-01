import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1번부터 N번까지 사람이 원으로 자리 잡는다
        // K번째 사람이 빠진다.
        // 나머지 사람으로 다시 원을 만들고 빠진 사람부터 다시 K를 카운트
        // N명이 모두 빠질 때까지 반복
        // 입력 : N, K
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }
        StringBuilder sb = new StringBuilder("<");
        while (!q.isEmpty()) {
            for (int i = 1; i < K; i++) {
                q.add(q.poll());  // K번째가 될 때까지 뒤로 보냄
            }
            sb.append(q.poll());      // K번째 제거
            if (!q.isEmpty()) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);

    }
}