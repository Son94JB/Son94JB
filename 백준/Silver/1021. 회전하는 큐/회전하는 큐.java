import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        // 1-indexed 위치를 그대로 저장 (1, 2, ..., N)
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken()); // 처음 큐에서의 위치

            // 현재 큐에서 target의 위치 탐색
            int idx = queue.indexOf(target);
            int size = queue.size();

            if (idx <= size - idx) {
                // 2번 연산 (왼쪽 이동)
                count += idx;
                for (int j = 0; j < idx; j++) {
                    queue.addLast(queue.removeFirst());
                }
            } else {
                // 3번 연산 (오른쪽 이동)
                count += size - idx;
                for (int j = 0; j < size - idx; j++) {
                    queue.addFirst(queue.removeLast());
                }
            }

            queue.removeFirst(); // 1번 연산 (카운트 제외)
        }

        System.out.println(count);
    }
}