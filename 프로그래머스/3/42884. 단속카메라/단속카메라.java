import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = -30001;
        int count = 0;
        for(int[] route : routes) {
            if(route[0] > camera) {
                camera = route[1];
                count++;
            }
        }
        return count;
    }
}