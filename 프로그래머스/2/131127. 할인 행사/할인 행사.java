import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 마트에서 금액을 지불하면 10일간 회원이 된다. 회원을 대상으로 매일 한가지 제품을 할인한다.
        // 할인 제품은 하루에 하나만 구매 가능
        // 자신이 원하는 제품과 수량이 할인하는 10일과 연속으로 일치할 때, 가입하려고 함
        // 이 때, 회원가입이 가능한 총 일 수를 return
        // 가능한 날이 없으면 0을 return

        // discount를 돌면서 want와 number를 비교하며 확인
        // 만약 중간에 want에 없는 품목이 나오면 그만하고 해당 일 수부터 다시
        // 일단 want의 내용을 number에 맞춰 만들고 확인될 때마다 하나씩 빼기?
        int answer = 0;
        List<String> arr = new ArrayList<>();
        for (int i = 0; i < want.length; i++) {
            int repeat = number[i];
            for (int j = 0; j < repeat; j++) {
                arr.add(want[i]);
            }
        }

        List<String> copy = new ArrayList<>(arr);
        int idx = 0;

        while (idx <= discount.length - 10) {
            for (int i = idx; i < idx + 10; i++) {
                // want에 없는 품목이라면
                if (!Arrays.asList(want).contains(discount[i])) {
                    // 끊긴 곳부터 다시
                    idx = i + 1;
                    copy = new ArrayList<>(arr);
                    break;
                } else {
                    // discount에 수량을 초과하는 품목이라면
                    if (!copy.contains(discount[i])) {
                        idx++;
                        copy = new ArrayList<>(arr);
                        break;
                    };
                    copy.remove(discount[i]);
                    if (copy.isEmpty()) {
                        answer++;
                        copy = new ArrayList<>(arr);
                        idx++;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}