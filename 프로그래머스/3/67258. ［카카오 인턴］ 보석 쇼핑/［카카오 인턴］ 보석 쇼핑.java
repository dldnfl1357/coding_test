import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = {};

        HashSet<String> gemSet = new HashSet<>();
        HashSet<String> nowGemSet = new HashSet<>();

        //O(100,000)
        for(String gem : gems)
            gemSet.add(gem);

        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        //O(100,000)
        while(end < gems.length) {
            nowGemSet.add(gems[end]);
            if(gemSet.equals(nowGemSet)) {
                if(min > end - start + 1)
                    min = end - start + 1;
                start++;
            }
            else {
                end++;
            }
        }
        return answer;
    }
}