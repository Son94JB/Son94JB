import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 토핑의 종류가 같도록 2등분을 하는 경우의 수를 return
        // 만약 토핑 종류를 동일하게 나눌 수 없다면 -1을 return
        int count = 0;

        // pivot을 통해 왼쪽, 오른쪽으로 옮기면서 토핑 종류를 계산
        Map<Integer, Integer> left_topping = new HashMap<>();
        Map<Integer, Integer> right_topping = new HashMap<>();

        int pivot = 0;

        // 처음엔 모두 오른쪽에 담아둔다
        for (int i = 0; i < topping.length; i++) {
            right_topping.put(topping[i], right_topping.getOrDefault(topping[i], 0) + 1);
        }


        while (pivot < topping.length) {
            int lt = left_topping.size();
            int rt = right_topping.size();
            left_topping.put(topping[pivot], left_topping.getOrDefault(topping[pivot], 0) + 1);
            right_topping.put(topping[pivot], right_topping.get(topping[pivot]) - 1);
            if (right_topping.get(topping[pivot]) == 0) right_topping.remove(topping[pivot]);
            if (lt == rt) count++;
            pivot++;
        }

        return count;
    }
}