import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int n = progresses.length;

        // 각 작업이 완료되는 데 걸리는 날수 계산
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int i = 0;
        while (i < n) {
            int count = 1;
            // 현재 기준 작업의 완료일보다 같거나 빠른 작업들을 함께 배포
            while (i + count < n && days[i + count] <= days[i]) {
                count++;
            }
            answer.add(count);
            i += count;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}