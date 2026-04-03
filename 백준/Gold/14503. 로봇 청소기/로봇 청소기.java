import java.io.*;
import java.util.*;

public class Main {
    public static int[][] room;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        // 방의 크기 N, M
        // 로봇 청소기의 처음 위치(r, c), 보는 방향 d(북 : 0, 동 : 1, 남 : 2, 서 : 3)
        // N개 줄에 방의 상태 표시(벽 : 1, 청소 안 된 상태 : 0)
        // 방의 끝은 항상 벽이다

        // 1. 현재 칸이 청소되지 않은 경우, 청소한다
        // 2. 주변 4칸 중 청소되지 않은 빈 칸이 없다면
        // 2-1. 바라보는 방향을 유지하고 후진이 가능하면 한 칸 후진, 다시 1번으로
        // 2-2. 후진이 불가능하면 멈춘다.
        // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있다면
        // 3-1. 반시계 방향으로 90도 회전
        // 3-2. 바라보는 방향 기준으로 앞 칸이 청소되지 않은 상태면 한 칸 전진
        // 3-3. 1번으로 돌아간다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] roomSize = br.readLine().split(" ");
        int N = Integer.parseInt(roomSize[0]);
        int M = Integer.parseInt(roomSize[1]);

        String[] robotStart = br.readLine().split(" ");
        int r = Integer.parseInt(robotStart[0]);
        int c = Integer.parseInt(robotStart[1]);
        int d = Integer.parseInt(robotStart[2]);

        room = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(temp[j]);
            }
        }

        check(r, c, d, N, M);
        System.out.println(count);

    }

    public static int[] check(int x, int y, int d, int N, int M) {
        if (room[x][y] == 0) {
            room[x][y] = -1;
            count++;
        }
        // 1. 현재 칸 청소

        // 반시계 회전: 북->서->남->동->북
        int[] leftTurn = {3, 0, 1, 2};

        // 전진 방향 (북, 동, 남, 서)
        int[] forwardX = {-1, 0, 1, 0};
        int[] forwardY = {0, 1, 0, -1};

        // 2. 주변 4칸 중 청소 안 된 빈 칸이 있는지 확인
        boolean isCleanable = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + forwardX[i];
            int ny = y + forwardY[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 0) {
                isCleanable = true;
                break;
            }
        }

        if (!isCleanable) {
            // 2. 청소 안 된 빈 칸이 없는 경우 -> 후진 시도
            int bx = x + forwardX[(d + 2) % 4]; // 현재 방향의 반대
            int by = y + forwardY[(d + 2) % 4];

            if (bx >= 0 && by >= 0 && bx < N && by < M && room[bx][by] != 1) {
                // 2-1. 후진 가능
                return check(bx, by, d, N, M);
            } else {
                // 2-2. 후진 불가 -> 종료
                return new int[]{x, y};
            }
        } else {
            // 3. 청소 안 된 빈 칸이 있는 경우
            // 3-1. 반시계 방향으로 90도 회전
            int nd = leftTurn[d];

            // 3-2. 앞 칸이 청소 안 된 상태면 전진
            int nx = x + forwardX[nd];
            int ny = y + forwardY[nd];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && room[nx][ny] == 0) {
                return check(nx, ny, nd, N, M);
            } else {
                // 앞 칸이 청소됐거나 벽이면 전진 없이 회전만 하고 다시 1번으로
                return check(x, y, nd, N, M);
            }
        }
    }
}