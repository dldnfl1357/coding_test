import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 1;
        long right = (long) times[0] * n;

        while (left < right) {
            long mid = (left + right) / 2;

            long total = 0;
            for (int t : times) {
                total += mid / t;
            }

            if (total >= n) {
                right = mid;      // 가능하니까 왼쪽 탐색
            } else {
                left = mid + 1;   // 부족하니까 오른쪽 탐색
            }
        }

        return left;
    }
}