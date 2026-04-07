import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // n번째 라운드마다 n의 배수의 문을 연다
        // 방의 총 수만큼 라운드를 반복한 뒤, 열린 문의 개수를 리턴
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력은 첫 줄에 총 테스트 케이스 T
        // 다음 줄부터 각각 총 방의 개수
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(doorsOpen(n));
        }

    }

    public static int doorsOpen(int n) {
        List<Integer> list = new ArrayList<>();
        // 1은 열림, 0은 닫힘
        // 0번 방은 없으니 +1로 계산하기 쉽게
        for (int i = 0; i < n+1; i++) {
            list.add(0);
        }

        //  각 라운드 수의 배수가 되는 문을 열고 닫는다
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 범위 초과는 패스
                if (i*j > n) break;
                if (list.get(i*j) == 1) {
                    list.set(i*j, 0);
                } else {
                    list.set(i*j, 1);
                }
            }
        }
        return Collections.frequency(list, 1);
    }
}