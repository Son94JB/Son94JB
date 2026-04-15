import java.io.*;
import java.util.*;

public class Main {
    public static int[][] paper;
    public static int white = 0;
    public static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    // (x, y)부터 size 크기 검사
    public static void divide(int x, int y, int size) {
        if (check(x, y, size)) {
            if (paper[x][y] == 0) white++;
            else blue++;
            return;
        }

        int newSize = size / 2;

        divide(x, y, newSize);                         // 왼쪽 위
        divide(x, y + newSize, newSize);               // 오른쪽 위
        divide(x + newSize, y, newSize);               // 왼쪽 아래
        divide(x + newSize, y + newSize, newSize);     // 오른쪽 아래
    }

    // 해당 영역이 모두 같은 색인지 검사
    public static boolean check(int x, int y, int size) {
        int color = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}