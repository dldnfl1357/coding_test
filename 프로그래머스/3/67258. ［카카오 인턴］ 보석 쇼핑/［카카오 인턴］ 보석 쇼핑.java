import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};

        HashSet<String> gemSet = new HashSet<>();
        HashMap<String, Integer> nowGemSet = new HashMap<>();

        //O(100,000)
        for(String gem : gems)
            gemSet.add(gem);

        int start = 0;
        int end = -1;
        int min = Integer.MAX_VALUE;

        //O(100,000)
        while(end < gems.length) {
            if(gemSet.size() == nowGemSet.size()) {
                if(min > end - start + 1) {
                    min = end - start + 1;
                    answer = new int[]{start+1, end+1};
                }
                nowGemSet.merge(gems[start], -1, (old, d) -> old + d <= 0 ? null : old + d);
                start++;
            }
            else {
                end++;
                if(end >= gems.length) break;
                nowGemSet.merge(gems[end], 1, Integer::sum);
            }
        }
        return answer;
    }
}