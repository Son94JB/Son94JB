import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // (값, 원래 인덱스) 쌍을 정렬
        // 값이 같으면 인덱스 오름차순
        Integer[] idx = new Integer[N];
        for (int i = 0; i < N; i++) idx[i] = i;

        Arrays.sort(idx, (a, b) -> {
            if (A[a] != A[b]) return A[a] - A[b];
            return a - b;
        });

        // idx[pos] = i : A[i]가 B의 pos번째 위치에 들어가야 함
        // P[i] = pos
        int[] P = new int[N];
        for (int pos = 0; pos < N; pos++) {
            P[idx[pos]] = pos;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(P[i]);
        }
        System.out.println(sb);
    }
}