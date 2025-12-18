class Solution {
    static String[] chars = {"A", "E", "I", "O", "U"};
    static String target;
    static int count = 0;
    static int answer = 0;
    
    void dfs(String current) {
        if (answer != 0) return;
        if (current.equals(target)) {
            answer = count;
            return;
        }
        if (current.length() == 5) return;

        for (String v : chars) {
            count++;
            dfs(current + v);
        }
    }

    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }
}