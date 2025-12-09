import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> queue = new ArrayBlockingQueue<>(n*m);
        int[][] dist =  new int[n][m];

        queue.offer(new int[]{0,0});
        dist[0][0] = 1;

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int x = xy[0];
            int y = xy[1];

            if(x == n - 1 && y == m - 1)
                return dist[x][y];

            // 상 (x-1)
            if(x - 1 >= 0 && maps[x-1][y] == 1) {
                maps[x-1][y] = 0;
                dist[x-1][y] = dist[x][y] + 1;
                queue.offer(new int[]{x-1, y});
            }
            // 하 (x+1)
            if(x + 1 <= n - 1 && maps[x+1][y] == 1) {
                maps[x+1][y] = 0;
                dist[x+1][y] = dist[x][y] + 1;
                queue.offer(new int[]{x+1, y});
            }
            // 좌 (y-1)
            if(y - 1 >= 0 && maps[x][y-1] == 1) {
                maps[x][y-1] = 0;
                dist[x][y-1] = dist[x][y] + 1;
                queue.offer(new int[]{x, y-1});
            }
            // 우 (y+1)
            if(y + 1 <= m - 1 && maps[x][y+1] == 1) {
                maps[x][y+1] = 0;
                dist[x][y+1] = dist[x][y] + 1;
                queue.offer(new int[]{x, y+1});
            }
        }
        return -1;
    }
}