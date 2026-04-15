import java.io.*;
import java.util.*;

public class Solution {

    public static int solution(String name) {
        int n = name.length();

        // 1. 상하 이동 합산
        int vertical = 0;
        for (char c : name.toCharArray()) {
            vertical += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 2. 좌우 이동 최솟값
        int horizontal = n - 1; // 기본값: 오른쪽으로 끝까지

        // A가 있다면 해당 구간을 건너 뛰는게 더 빠른지 확인
        for (int i = 1; i < n; i++) {
            // i번째부터 연속 A 구간 끝 찾기
            int j = i;
            while (j < n && name.charAt(j) == 'A') {
                j++;
            }

            // 오른쪽 갔다 되돌아오기 vs 왼쪽 먼저 갔다 오른쪽 가기
            horizontal = Math.min(
                    horizontal,
                    Math.min(
                            2 * (i - 1) + (n - j),  // 오른쪽 i-1까지 왕복 + 나머지 오른쪽
                            (i - 1) + 2 * (n - j)   // 나머지 왼쪽 왕복 + 오른쪽 i-1
                    )
            );
        }

        return vertical + horizontal;
    }

    public static void main(String[] args) throws IOException {
        // 커서를 최소로 움직여 해당 이름을 만들 때
        // 최소 움직임을 출력
        // 주어지는건 이름값
        // 처음 시작은 A로 시작한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        
        System.out.println(solution(name));


    }

}