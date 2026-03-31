import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        // 같은 파티에 참가한 사람끼리 묶어준다
        // 진실을 아는 사람들의 root를 구한다
        // 해당 root와 같은 root의 파티를 제외한다(거짓말 못하는 파티)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수 n, 파티 수 m
        // 진실을 아는 사람 수, 그 사람의 번호
        // 파티에 참가하는 사람 수, 참가자 번호
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        };

        // 진실을 아는 사람 입력
        st = new StringTokenizer(br.readLine());
        int trueCount = Integer.parseInt(st.nextToken());
        Set<Integer> trueSet = new HashSet<>();
        for (int i = 0; i < trueCount; i++) {
            trueSet.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 참가자 입력
        int[][] parties = new int[m][];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            parties[i] = new int[count];
            for (int j = 0; j < count; j++) {
                parties[i][j] = Integer.parseInt(st.nextToken());
            }
            // 같은 파티 사람들을 모두 union
            for (int j = 1; j < count; j++) {
                union(parties[i][0], parties[i][j]);
            }
        }

        // 진실을 아는 사람들의 root 수집
        Set<Integer> trueRoots = new HashSet<>();
        for (int person : trueSet) {
            trueRoots.add(find(person));
        }

        // 파티별로 진실을 아는 그룹 포함 여부 확인
        int answer = 0;
        for (int[] party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (trueRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) answer++;
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        };
        return parent[x];
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        };
    }
}