import java.util.*;
class Solution {
    public static List<List<Integer>> map = new ArrayList<>();
    public static int banSize = 0;
    private Set<Set<Integer>> resultSet = new HashSet<>();

    private boolean contains(int[] arr, int length, int value) {
        for (int j = 0; j < length; j++) {
            if (arr[j] == value) return true;
        }
        return false;
    }

    private void DFS(int level, int[] arr) {
        if (level == banSize) {
            // arr를 Set으로 변환해서 저장 (순서 무시)
            Set<Integer> set = new HashSet<>();
            for (int v : arr) {
                set.add(v);
            }
            resultSet.add(set);
            return;
        }
        for (int i : map.get(level)) {
            if (!contains(arr, level, i)) {
                arr[level] = i;
                DFS(level + 1, arr);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        // O(8*8*8)
        for(String bannedId: banned_id) {
            char[] banArray = bannedId.toCharArray();
            int idx = -1;
            List<Integer> list = new ArrayList<>();
            for(String userId: user_id) {
                idx++;
                if(userId.length() != banArray.length) continue;
                char[] userArray = userId.toCharArray();

                boolean include = true;

                for(int i =0; i <userArray.length; i++) {
                    if(banArray[i] != '*' && banArray[i] != userArray[i])
                        include = false;
                }
                if(include)
                    list.add(idx);
            }
            map.add(list);
        }
        banSize = banned_id.length;
        for(int idx : map.get(0)) {
            DFS(0, new int[banSize]);
        }
        return resultSet.size();
    }
}