class Solution {
    static public int targetNumber;
    static public int lastLevel;
    static public int numberList[];
    static public int answer;
    
    public static void DFS(int depth, int index, int sum) {
        if(depth == lastLevel) {
            if(sum == targetNumber) answer++;
            return;
        }
        depth++;
        index++;

        DFS(depth, index, sum + numberList[index]);
        DFS(depth, index, sum - numberList[index]);
    }
    
    public int solution(int[] numbers, int target) {
        targetNumber = target;
        numberList = numbers;
        lastLevel = numbers.length;

        DFS(1, 0, numbers[0]);
        DFS(1, 0, -numbers[0]);

        return answer;
    }
}