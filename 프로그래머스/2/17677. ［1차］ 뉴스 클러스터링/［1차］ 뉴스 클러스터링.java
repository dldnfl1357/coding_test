import java.util.*;
class Solution {
    public static int solution(String str_, String str__) {
        String str1 = str_.toLowerCase();
        String str2 = str__.toLowerCase();
        Map<String, Integer> string1 = new HashMap<>();
        Map<String, Integer> string2 = new HashMap<>();

        for(int i=0;i<str1.length()-1;i++) {
            if (Character.isLowerCase(str1.charAt(i)) &&
                    Character.isLowerCase(str1.charAt(i + 1))) {
                String now = "" + str1.charAt(i) + str1.charAt(i+1);
                if(string1.containsKey(now)) string1.replace(now, string1.get(now) + 1);
                else string1.put(now, 1);
            }
        }
        for(int i=0;i<str2.length()-1;i++) {
            if (Character.isLowerCase(str2.charAt(i)) &&
                    Character.isLowerCase(str2.charAt(i + 1))) {
                String now = "" + str2.charAt(i) + str2.charAt(i+1);
                if(string2.containsKey(now)) string2.replace(now, string2.get(now) + 1);
                else string2.put(now, 1);
            }
        }
        int intersectionCount = 0;
        for(var i : string1.entrySet()) {
            if(string2.containsKey(i.getKey())) {
                intersectionCount += Math.min(string1.get(i.getKey()), string2.get(i.getKey()));
            }
        }

        int unionCount = 0;
        for(var i : string1.entrySet()) {
            unionCount += i.getValue();
        }

        for(var i : string2.entrySet()) {
            if(string1.containsKey(i.getKey())) {
                unionCount += Math.max(string1.get(i.getKey()), string2.get(i.getKey()));
                unionCount -= string1.get(i.getKey());
            }
            else  {
                unionCount += i.getValue();
            }
        }
        return intersectionCount == 0 && unionCount == 0 ?
                65536 : (int) intersectionCount*65536/unionCount;
    }
}