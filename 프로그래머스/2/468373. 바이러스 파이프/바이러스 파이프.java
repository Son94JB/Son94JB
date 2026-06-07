import java.util.*;

class Solution {
    static int[][] edges;
    static int answer = 0;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        Solution.edges = edges;
        
        Set<Integer> infected = new HashSet<>();
        infected.add(infection);

        dfs(infected, k);
        return answer;
    }
    
        static void dfs(Set<Integer> infected, int remainK) {
        answer = Math.max(answer, infected.size());

        if (remainK == 0) return;

        for (int type = 1; type <= 3; type++) {
            Set<Integer> newInfected = spread(infected, type);
            dfs(newInfected, remainK - 1);
        }
    }

    static Set<Integer> spread(Set<Integer> infected, int type) {
        Set<Integer> newInfected = new HashSet<>(infected);

        // 감염된 노드 기준으로 같은 타입 간선 탐색
        Queue<Integer> queue = new LinkedList<>(infected);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] edge : edges) {
                if (edge[2] != type) continue;

                int neighbor = -1;
                if (edge[0] == node) neighbor = edge[1];
                else if (edge[1] == node) neighbor = edge[0];

                if (neighbor != -1 && !newInfected.contains(neighbor)) {
                    newInfected.add(neighbor);
                    queue.add(neighbor);  // 새로 감염된 노드도 전파 가능
                }
            }
        }
        return newInfected;
    }
}