class Solution {
    public String solution(String s) {
        String answer = "";
                boolean flag = true;
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                if (flag) {
                    c = Character.toUpperCase(c);
                    answer += c;
                    flag = false;
                }
                else {
                    c = Character.toLowerCase(c);
                    answer += c;
                }
            }

            if (c == ' ') {
                answer += c;
                flag = true;
            }

        }
        return answer;
    }
}