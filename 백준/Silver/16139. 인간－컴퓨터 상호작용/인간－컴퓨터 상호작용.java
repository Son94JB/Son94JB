import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int n = str.length();

        // 미리 알파벳 전체에 대한 누적합을 만들어 두기
        int[][] prefix = new int[n][26];

        // 첫 번째 문자 초기화
        prefix[0][str.charAt(0) - 'a'] = 1;

        // 2차원 누적합 한 번만 계산 O(N)
        for (int i = 1; i < n; i++) {
            for (int c = 0; c < 26; c++) {
                prefix[i][c] = prefix[i - 1][c];
            }
            prefix[i][str.charAt(i) - 'a']++;
        }

        int q = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < q; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = inputs[0].charAt(0) - 'a';
            int l = Integer.parseInt(inputs[1]);
            int r = Integer.parseInt(inputs[2]);

            int result = (l == 0) ? prefix[r][a] : prefix[r][a] - prefix[l - 1][a];
            sb.append(result).append('\n');
        }

        System.out.print(sb);
    }
}