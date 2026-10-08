class Solution {
    
    static int dist_limit;
    static int split_limit;
    static long leaf_nodes;
    
    public long solution(int dist_limit, int split_limit) {

        Solution.dist_limit = dist_limit;
        Solution.split_limit = split_limit;

        recursive(1, 1, dist_limit, 0);

        return leaf_nodes;
    }
    
    static void recursive(long nodes, long curSl, long remainDl, long leaves) {
        // nodes : 현재 깊이의 노드 개수, curSl : 현재 분배도, remainDl : 남은 분배 노드 개수, leaves : 확정된 리프 노드 개수
        // 정답 갱신 → k = 2, 3에 대해 곱 검사 → 이번 깊이의 분배 노드 수 계산 → 다음 깊이의 노드 수와 리프 수 계산 → 재귀
        leaf_nodes = Math.max(leaf_nodes, leaves + nodes);

        if (remainDl == 0) return;

        long dist_nodes = Math.min(nodes, remainDl);

        for (int k = 2; k <= 3; k++) {
            if (curSl * k > split_limit) continue;
            recursive(dist_nodes * k, curSl * k, remainDl - dist_nodes, leaves + (nodes - dist_nodes));
        }

    }
}