import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        // 두 선수의 번호가 주어질 때
        // 몇 라운드에서 만나는지 출력

        // 입력 받기(총 인원, 두 선수의 번호)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int p1 = Integer.parseInt(st.nextToken());
        int p2 = Integer.parseInt(st.nextToken());

        // p1 이 항상 p2보다 작도록
        if (p1 > p2) {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }

        int count = 1;

        while (!isMatch(p1, p2)) {
            if (p1 % 2 == 0) {
                p1 = p1/2;
            } else {
                p1 = p1/2 + 1;
            }

            if (p2 % 2 == 0) {
                p2 = p2/2;
            } else {
                p2 = p2/2 + 1;
            }

            if (n % 2 == 0) {
                n = n/2;
            } else {
                n = n/2 + 1;
            }

            count++;
        }
        System.out.println(count);
    }

    static boolean isMatch(int a, int b) {
        return a % 2 == 1 && a + 1 == b;
    }

}