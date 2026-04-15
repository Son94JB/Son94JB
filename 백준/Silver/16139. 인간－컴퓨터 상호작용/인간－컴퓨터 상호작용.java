import java.io.*;
import java.util.*;

public class Main {
    public static int[] prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            String[] inputs = br.readLine().split(" ");
            char a = inputs[0].charAt(0);

            // prefix 배열 초기화
            prefix = new int[str.length()];

            // 누적합 계산
            prefix[0] = (str.charAt(0) == a) ? 1 : 0;

            for (int j = 1; j < str.length(); j++) {
                if (str.charAt(j) == a) {
                    prefix[j] = prefix[j - 1] + 1; // ✅ +1 누적
                } else {
                    prefix[j] = prefix[j - 1]; // ✅ 이전 값 전파
                }
            }

            int l = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);

            // l이 0이면 그냥 prefix[r], 아니면 prefix[r] - prefix[l-1]
            int result = (l == 0) ? prefix[r] : prefix[r] - prefix[l - 1];
            System.out.println(result);
        }
    }
}