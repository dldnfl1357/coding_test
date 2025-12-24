import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[1] = 0;

        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int count = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next :adj.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);

                    if (dist[next] > max) {
                        max = dist[next];
                        count = 1;
                    } else if (dist[next] == max)
                        count++;
                }
            }
        }
        return count;
    }
}