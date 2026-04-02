import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수행해야 하는 연산의 수 M
        // S는 처음엔 공집합이다.
        // add x : S에 x추가
        // remove x : S에서 x제거
        // check x : x가 있으면 1, 없으면 0
        // toggle x : S에 x가 있으면 제거, 없으면 추가
        // all x : S를 {1, 2, 3, ... , 19, 20}으로 바꾼다
        // empty x : S를 공집합으로 바꾼다
        // check 연산이 주어질 때마다 결과를 출력한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        Set<Integer> S = new HashSet<>();

        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            String task = s[0];
            int a = s.length > 1 ? Integer.parseInt(s[1]) : -1;

            switch (task) {
                case "add":    add(S, a); break;
                case "remove": remove(S, a); break;
                case "check":  check(S, a, sb); break;
                case "toggle": toggle(S, a); break;
                case "all":    all(S); break;
                case "empty":  S.clear(); break;
            }
        }

        System.out.println(sb);


    }

    // add
    public static void add(Set<Integer> arr, int a) {
        arr.add(a);
    }

    // remove
    public static void remove(Set<Integer> arr, int a) {
        if (arr.contains(a)) {
            arr.remove((Integer) a);
        }
    }

    // check
    public static void check(Set<Integer> arr, int a, StringBuilder sb) {
        sb.append(arr.contains(a) ? "1" : "0").append("\n");
    }

    // toggle
    public static void toggle(Set<Integer> arr, int a) {
        if (arr.contains(a)) {
            arr.remove(a);
        } else {
            arr.add(a);
        }
    }

    // all
    public static void all(Set<Integer> arr) {
        arr.clear();
        for (int i = 1; i < 21; i++) {
            arr.add(i);
        }
    }
}