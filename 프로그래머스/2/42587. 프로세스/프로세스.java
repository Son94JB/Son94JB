import java.io.*;
import java.util.*;

class Solution {
        public static int solution(int[] properties, int location) {
        // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
        // 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
        // 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
        //  3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니다.
        int count = 0;
        int len = properties.length;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            q.offer(new int[] {i, properties[i]});
        }

        while (!q.isEmpty()) {
            int[] current = q.poll();

            // 나보다 우선순위 높은 게 있는지 확인
            boolean isMax = true;
            for (int[] process : q) {
                if (process[1] > current[1]) {
                    isMax = false;
                    break;
                }
            }

            if (!isMax) {
                q.offer(current); // 뒤로 다시 넣기
            } else {
                count++;
                if (current[0] == location) break;
                // 찾던 프로세스면 count 반환
            }
        }

        return count;
    }
}