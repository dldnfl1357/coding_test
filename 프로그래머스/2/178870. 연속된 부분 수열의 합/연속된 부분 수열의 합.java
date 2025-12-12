class Solution {
    static int[] sequence = new int[]{};
    static int k;
    static int[] answer = new int[]{Integer.MAX_VALUE,0};
    
    private void DFS(int start, int end, int sum) {
        if(end >= sequence.length || sum > k) return;
        if(sum == k) {
            if(end - start + 1 < answer[1] - answer[0] + 1) {
                answer[0] = start;
                answer[1] = end;
            }
            if(start < answer[0]) {
                answer[0] = start;
                answer[1] = end;
            }

        }
        if(end + 1 >= sequence.length) return;

        int newSum = sum + sequence[end + 1];
        DFS(start, end + 1, newSum);
    }
    
    public int[] solution(int[] inputSequence, int inputK) {
        sequence = inputSequence;
        k = inputK;
        for(int i = 0; i < sequence.length; i++)
            DFS(i, i, sequence[i]);
        return answer;
    }
}