class Solution {
    
    static int[] answer = new int[2];
    
    public int[] solution(int[][] arr) {

        // 0 과 1로 이루어진 2^n * 2^n 크기의 2차원 정수 배열 arr이 있다.
        // 이 배열을 쿼드 트리와 같은 방식으로 압축하려 한다.
        // 압축하려는 특정 영역을 S라고 할 때, 이 S의 수가 모두 같다면 그 수 하나로 압축한다.
        // 그렇지 않다면, S를 정확히 4개의 균일한 정사각형으로 쪼갠 뒤, 각 정사각형을 위와 같은 방법으로 압축한다.

        // 압축이 모두 끝나고 최종적으로 남는 0과 1의 개수를 return

        zip(arr, 0, 0, arr.length);
        return answer;

    }
    
    
    public static void zip(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {   // 다른 수 발견 → 4분할
                    int half = size / 2;
                    zip(arr, x, y, half);
                    zip(arr, x, y + half, half);
                    zip(arr, x + half, y, half);
                    zip(arr, x + half, y + half, half);
                    return;                 // 중요: 바로 빠져나오기
                }
            }
        }

        answer[first]++;
    }
}