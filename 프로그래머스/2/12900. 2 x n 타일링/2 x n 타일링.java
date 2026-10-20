class Solution {

    public int solution(int n) {
        // 길이가 세로가 2, 가로가 n인 직사각형을 세로가 2, 가로가 1인 직사각형으로 채운다고 할 때,
        // 그 경우의 수를 찾아라
        // 가로의 길이 n은 60,000이하의 자연수
        // 경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return

        // 길이가 1인 경우부터 계산해보면 피보니치 수열이 된다.
        // f(1) = 1, f(2) = 2 인 피보니치 수열

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