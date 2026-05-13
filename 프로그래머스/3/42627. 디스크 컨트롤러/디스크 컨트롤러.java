import java.util.*;

class Solution {
    public static int solution(int[][] jobs) {
        int n = jobs.length;

        // 인덱스 보존을 위해 {요청시각, 소요시간, 번호} 로 변환
        int[][] indexed = new int[n][3];
        for (int i = 0; i < n; i++) {
            indexed[i][0] = jobs[i][0];
            indexed[i][1] = jobs[i][1];
            indexed[i][2] = i;
        }

        // 요청시각 순 정렬 (같으면 번호 순)
        Arrays.sort(indexed, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        // 우선순위 큐: 소요시간 → 요청시각 → 번호 순
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[0] != b[0]) return a[0] - b[0];
            return a[2] - b[2];
        });

        int time = 0, idx = 0, totalWait = 0;

        while (idx < n || !pq.isEmpty()) {
            // 현재 시각까지 도착한 작업 모두 큐에 추가
            while (idx < n && indexed[idx][0] <= time) {
                pq.offer(indexed[idx++]);
            }

            if (pq.isEmpty()) {
                // 처리할 작업 없으면 다음 작업 도착 시각으로
                time = indexed[idx][0];
                continue;
            }

            // 우선순위 가장 높은 작업 처리
            int[] job = pq.poll();
            time += job[1];
            totalWait += time - job[0];
        }

        return totalWait / n;
    }
}