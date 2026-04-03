import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 수행해야 하는 명령의 수 n
        // push_front x : 정수 x를 덱(deque) 맨 앞에 넣는다
        // push_back x : 정수 x를 덱 맨 뒤에 넣는다
        // pop_front : 덱의 가장 앞에 있는 수를 빼고 그 수를 출력. 없는 경우에는 -1을 출력
        // pop_back : 덱의 가장 뒤에 있는 수를 빼고 그 수를 출력. 없는 경우에는 -1을 출력
        // size : 덱의 정수의 개수 출력
        // empty : 덱이 비어있으면 1, 아니면 0을 출력
        // front : 덱의 가장 앞에 있는 정수를 출력. 없는 경우에는 -1을 출력
        // back : 덱의 가장 뒤에 있는 정수를 출력. 없는 경우에는 -1을 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            String task = s[0];
            int a = s.length > 1 ? Integer.parseInt(s[1]) : -1;

            switch (task) {
                case "push_front": dq.addFirst(a); break;
                case "push_back": dq.addLast(a); break;
                case "pop_front":  pop_front(dq, sb); break;
                case "pop_back": pop_back(dq, sb); break;
                case "size": sb.append(dq.size()).append("\n"); break;
                case "empty": empty(dq, sb); break;
                case "front": front(dq, sb); break;
                case "back": back(dq, sb); break;
            }
        }

        System.out.println(sb);

    }

    private static void empty(Deque<Integer> arr, StringBuilder sb) {
        sb.append(arr.isEmpty() ? "1" : "0").append("\n");
    }

    // pop_front
    public static void pop_front(Deque<Integer> arr, StringBuilder sb) {
        sb.append(!arr.isEmpty() ? arr.removeFirst() : "-1").append("\n");
    }

    // pop_back
    public static void pop_back(Deque<Integer> arr, StringBuilder sb) {
        sb.append(!arr.isEmpty() ? arr.removeLast() : "-1").append("\n");
    }

    // front
    public static void front(Deque<Integer> arr, StringBuilder sb) {
        sb.append(!arr.isEmpty() ? arr.peekFirst() : "-1").append("\n");
    }

    // back
    public static void back(Deque<Integer> arr, StringBuilder sb) {
        sb.append(!arr.isEmpty() ? arr.peekLast() : "-1").append("\n");
    }

}