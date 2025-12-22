import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] map = new int[102][102]; // 0: 미방문, 1: 테두리, 2: 내부

        // 1. 모든 직사각형을 그리면서 테두리와 내부 구분
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    // 내부인 경우
                    if (x > x1 && x < x2 && y > y1 && y < y2) {
                        map[x][y] = 2; // 내부로 마킹 (이동 불가)
                    }
                    // 테두리인 경우 (아직 다른 사각형의 내부가 아닐 때만)
                    else if (map[x][y] == 0) {
                        map[x][y] = 1; // 테두리
                    }
                }
            }
        }

        // 2. BFS로 최단 거리 탐색
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int startX = characterX * 2;
        int startY = characterY * 2;
        int endX = itemX * 2;
        int endY = itemY * 2;

        boolean[][] visited = new boolean[102][102];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == endX && y == endY) {
                return dist / 2; // 2배로 확대했으므로 나누기 2
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 테두리(1)만 이동 가능
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102
                        && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        return 0;
    }
}