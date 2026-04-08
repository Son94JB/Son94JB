import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 그릇을 쌓는다. 그릇의 높이는 10cm이다.
        // 포개서 쌓으면 5cm가 늘어나고 반대 방향으로 쌓으면 10cm가 늘어난다.
        // 그릇은 최소 3개 최대 50개이다.
        // '(' 와 ')' 로 그릇을 나타낼 때, 총 그릇의 높이는?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int height = 10;
        String[] bowls = br.readLine().split("");
        for (int i = 0; i < bowls.length - 1; i++) {
            if (Objects.equals(bowls[i], bowls[i + 1])) {
                height += 5;
            } else {
                height += 10;
            }
        }

        System.out.println(height);
    }
}