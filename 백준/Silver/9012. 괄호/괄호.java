import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ( ) 로 VPS 찾기
        // test case T와 T개의 입력이 주어짐
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] ps = br.readLine().split("");
            if (VPS(ps)) {
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }

    public static boolean VPS(String[] ps) {
        boolean flag = true;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < ps.length; i++) {
            if (ps[i].equals("(")) {
                stack.push(ps[i]);
            }

            if (ps[i].equals(")")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    flag = false;
                    break;
                }
            }
        }

        if (!stack.isEmpty()) flag = false;
        return flag;
    }
}