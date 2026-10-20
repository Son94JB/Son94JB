class Solution {
    public long solution(long n) {
        // 임의의 양수 n이, 어떤 정수 x의 제곱인지 확인하려고 한다.
        // n이 x의 제곱이라면 x+1의 제곱을 return, 아니라면 -1을 return하는 함수를 만드시오
        // 1 <= n <= 50_000_000_000_000
        
        for (long i = 1; i <= Math.sqrt(n); i++) {
            if (i * i == n) return (long) Math.pow(i + 1, 2);
        }

        return -1;
    }
}