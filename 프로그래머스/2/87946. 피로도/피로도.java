import java.io.*;
import java.util.*;

public class Solution {

    static int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        backtrack(k, dungeons, visited, 0);
        return answer;
    }

    // count = 현재까지 탐색한 던전 수
    static void backtrack(int k, int[][] dungeons, boolean[] visited, int count) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i]) continue;

            int minFatigue = dungeons[i][0];  // 최소 필요 피로도
            int useFatigue = dungeons[i][1];  // 소모 피로도

            // 현재 피로도가 최소 필요 피로도보다 낮으면 탐색 불가
            if (k < minFatigue) continue;

            visited[i] = true;
            backtrack(k - useFatigue, dungeons, visited, count + 1);
            visited[i] = false;  // 백트래킹
        }

        // 더 이상 탐색 못하거나 모두 탐색 완료 → 최댓값 갱신
        answer = Math.max(answer, count);
    }
}