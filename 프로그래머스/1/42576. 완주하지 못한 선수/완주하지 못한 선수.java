import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for(String p : participant)
            list.add(p);
        for(String c : completion)
            list2.add(c);
        list.removeAll(list2);
        return list.get(0);
    }
}