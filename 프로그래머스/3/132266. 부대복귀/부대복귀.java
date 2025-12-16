import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for(int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        dist[destination] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        return Arrays.stream(sources).map(s -> dist[s]).toArray();
    }
}