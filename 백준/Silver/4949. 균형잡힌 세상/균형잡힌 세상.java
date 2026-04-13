import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals(".")) break;

            String input = line.substring(0, line.length() - 1);

            Stack<String> stack = new Stack<>();

            String[] str = input.split("");
            boolean isValid = true;

            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("(")) {
                    stack.push(str[i]);
                }
                if (str[i].equals(")")) {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
                if (str[i].equals("[")) {
                    stack.push(str[i]);
                }
                if (str[i].equals("]")) {
                    if (stack.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid && stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}