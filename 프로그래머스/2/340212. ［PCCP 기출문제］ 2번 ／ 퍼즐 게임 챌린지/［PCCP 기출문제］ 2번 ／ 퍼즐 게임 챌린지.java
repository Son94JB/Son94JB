class Solution {
    public static int solution(int[] diffs, int[] times, long limit) {
        // diff <= level 이면 소요 시간만큼 사용
        // diff > level 이면 diff-level만큼 틀림
        // 틀리면 현재 소요 시간 + 이전 소요 시간 만큼 더 소요
        // 퍼즐 게임에는 전체 제한 시간 limit
        // 제한 시간 내에 퍼즐을 모두 해결하기 위한 숙련도의 최솟값을 구하라

        // 이분탐색으로
        // 총 시간 <= limit -> lo 증가
        // 총 시간 > limit -> hi 감소
        int lo = 1;
        int hi = 0;
        for (int diff : diffs) {
            hi = Math.max(hi, diff);
        }

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (calcTime(diffs, times, mid) <= limit) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
    
    
    private static long calcTime(int[] diffs, int[] times, int level) {
        long total = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                total += times[i];
            } else {
                int mistakes = diffs[i] - level;
                int prev = (i == 0) ? 0 : times[i - 1];
                total += (long) mistakes * (times[i] + prev) + times[i];
            }
        }
        return total;
    }
}