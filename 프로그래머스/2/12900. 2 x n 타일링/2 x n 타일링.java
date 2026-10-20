class Solution {

    public int solution(int n) {
        // 길이가 세로가 2, 가로가 n인 직사각형을 세로가 2, 가로가 1인 직사각형으로 채운다고 할 때,
        // 그 경우의 수를 찾아라
        // 가로의 길이 n은 60,000이하의 자연수
        // 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return

        // 일단 직사각형을 배치하는 경우의 수는 2가지
        // 세로냐 가로냐
        // 세로로 놓으면 1 만큼 차지하고 가로로 놓으면 2 만큼 차지한다

        final int MOD = 1_000_000_007;

        if (n == 1) return 1;

        int p1 = 1;
        int p2 = 2;

        for (int i = 3; i <= n; i++) {
            int cur = (p1 + p2) % MOD;
            p1 =  p2;
            p2 = cur;
        }

        return p2;

    }

}