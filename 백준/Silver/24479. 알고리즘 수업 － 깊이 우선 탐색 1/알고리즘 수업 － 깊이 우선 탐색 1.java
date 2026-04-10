import java.io.*;
import java.util.*;

public class Main {

    public static int[] visited;
    public static List<List<Integer>> map;
    public static int N, M, R;
    public static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
        }
        visited = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            map.get(s).add(e);
            map.get(e).add(s); // 양방향
        }

        // 오름차순 정렬 (작은 번호 먼저 방문)
        for (int i = 1; i <= N; i++) {
            Collections.sort(map.get(i));
        }

        DFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void DFS(int r) {
        visited[r] = order++;

        for (int next : map.get(r)) {
            if (visited[next] == 0) {
                DFS(next);
            }
        }
    }
}