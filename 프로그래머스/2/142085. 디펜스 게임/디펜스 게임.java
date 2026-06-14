import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        // n 처음 가지고 있는 병사 수, k 무적권의 수, enemy 등장하는 적의 수
        // 라운드마다 적이 등장하고 그 적을 막으면 현재 병사 수에서 그만큼 차감된다.
        // 무적권으로 한 턴을 병사 소모 없이 넘길 수 있다.
        // 최대 몇 라운드 까지 가능할지 return
        int round = 0;
        int p = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (p < enemy.length) {
            pq.add(enemy[p]);
            if (pq.size() > k) {
                int t = pq.poll();
                if (n < t) {
                    round = p;
                    break;
                }
                n -= t;
            }
            p++;
        }

        if (p == enemy.length && n >= 0) round = enemy.length;

        return round;
    }
}