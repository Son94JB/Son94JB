class Solution {
    public int solution(int n) {
        // 연속된 자연수의 합으로 주어진 n을 나타내는 경우의 수
        // 투 포인터로 넘으면 왼쪽을 줄이고 모자라면 오른쪽을 늘리는 방식?
        int p1 = 1;
        int p2 = 1;
        int sum = 1;
        int answer = 1;

        while (p1 <= n / 2) { // p1이 n/2 초과하면 혼자서는 합 불가
            if (sum == n) {
                answer++;
                sum -= p1;
                p1++;
            } else if (sum > n) {
                sum -= p1;
                p1++;
            } else { // sum < n
                p2++;
                sum += p2;
            }
        }
        return answer;
    }
}