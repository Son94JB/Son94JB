import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {

            // 음식이 순서대로 있다. 그리고 각 음식을 먹는데 걸리는 시간은 food_times로 나타낸다.
            // 이 음식들을 순서대로 1초씩 먹을 때, k초 뒤에 어떤 음식부터 먹어야 하는지 출력
            // 그냥 1초 씩 세면 시간초과
        int n = food_times.length;

        long total = 0;
        for (int t : food_times) total += t;
        if (total <= k) return -1;                    // 5번

        int[][] sec = new int[n][2];
        for (int i = 0; i < n; i++) {
            sec[i][0] = food_times[i];                // 먹는 시간
            sec[i][1] = i + 1;                        // 음식 번호(1-based)
        }
        Arrays.sort(sec, (a, b) -> Integer.compare(a[0], b[0]));

        int prev = 0;       // 이전 층까지 이미 먹은 시간
        int idx = 0;        // 아직 남아 있는 음식의 시작 위치
        while (idx < n) {
            long remain = n - idx;
            long cost = (long) (sec[idx][0] - prev) * remain;   // 2번, 6번
            if (k < cost) break;                               // 이 층 안에서 끝남
            k -= cost;
            prev = sec[idx][0];
            // 같은 시간인 음식은 한꺼번에 제거
            while (idx < n && sec[idx][0] == prev) idx++;      // 3번
        }

        // 남은 음식을 원래 순서로 정렬 후 k % 개수 번째
        int[][] left = Arrays.copyOfRange(sec, idx, n);
        Arrays.sort(left, (a, b) -> Integer.compare(a[1], b[1]));   // 4번
        return left[(int) (k % left.length)][1];
        }

}