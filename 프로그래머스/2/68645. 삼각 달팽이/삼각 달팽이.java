class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n+1][n+1];
        int x = 0;
        int y = 0;
        int number = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(i % 3 == 0) arr[++x][y] = ++number;
                else if(i % 3 == 1) arr[x][++y] = ++number;
                else arr[--x][--y] = ++number;
            }
        }
        int[] answer = new int[number];
        int idx = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        return answer;
    }
}