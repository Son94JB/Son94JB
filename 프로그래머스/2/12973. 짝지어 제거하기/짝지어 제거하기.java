import java.util.*;

class Solution
{
    public int solution(String s)
    {
        // 소문자 문자열로 시작
        // 같은 알파벳이 2개 붙어있다면 제거하고 나머지 문자열을 잇는다.
        // 이 과정을 반복해 문자열을 모두 제거했다면 완료된다
        // 만약 제거를 성공적으로 할 수 있다면 1을 그렇지 않으면 0을 반환

        // 완탐을 돌리면서 하면 길이가 1,000,000 이하라서 가능은 할 것 같은데
        // 다른 방법이 있을 것 같다.

        // 스택으로 하면 되겠네

        Deque<Character> stack = new ArrayDeque<>();
        stack.push(s.charAt(0));

        int i = 1;

        while (i < s.length()) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else if (stack.peek() == s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
            i++;
        }

        if (stack.isEmpty()) return 1;
        else return 0;
    }
}