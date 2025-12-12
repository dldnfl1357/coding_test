import java.util.*;
class Solution {
    private void recursive(int n, int start, int end, int middle, List<int[]> histories)       {
        if (n == 1) {
            histories.add(new int[]{start, end});
            return;
        }
        recursive(n - 1, start, middle, end, histories);
        histories.add(new int[]{start, end});
        recursive(n - 1, middle, end, start, histories);
    }

    public int[][] solution(int n) {
        List<int[]> moves = new ArrayList<>();
        int start = 1;
        int middle = 2;
        int end = 3;
        recursive(n, start, end, middle, moves);
        return moves.toArray(new int[0][]);
    }
}