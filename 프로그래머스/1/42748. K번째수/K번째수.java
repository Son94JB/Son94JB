import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        // i~j 까지 자르고 정렬 후 k번째 수

        for (int i = 0; i < commands.length; i++) {
            int[] slice = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(slice);
            answer[i] = slice[commands[i][2] - 1];
        }

        return answer;
    }
}