import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 카드 개수가 주어진다.
        // 1 ~ N까지 숫자가 적혀있는 카드고 순서대로 쌓여있다(1 ~ N)
        // 제일 윗장의 카드를 버리고 그 다음 윗장의 카드를 제일 밑에 보낸다
        // 카드가 한 장 남을 때 까지 반복한다.
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            cards.add(i + 1);
        }

        while (cards.size() > 1) {
            cards.poll();              // 제일 윗장 버리기
            cards.add(cards.poll());   // 다음 윗장을 제일 밑으로
        }

        System.out.println(cards.peek());
    }
}