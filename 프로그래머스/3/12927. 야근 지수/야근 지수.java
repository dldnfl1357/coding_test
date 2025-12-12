import java.util.*;
class Solution {
    public static int numbersCount = 50000;
    
    public long solution(int n, int[] works) {
        int[] numbers = new int[numbersCount];
        for(int i = 0; i < works.length; i++)
            numbers[works[i]-1]++;
        int lastIndex = numbersCount - 1;
        while(n>0){
            if(lastIndex < 0) break;
            if (numbers[lastIndex] > 0) {
                numbers[lastIndex]--;
                n--;
                if(lastIndex > 0)
                    numbers[lastIndex - 1]++;
            }
            if (numbers[lastIndex] == 0) {
                lastIndex--;
            }
        }
        long answer = 0;
        for(int i = 0; i < numbers.length; i++) {
            for(int j = 0; j < numbers[i]; j++)
                answer += (i + 1) * (i + 1);
        }
        return answer;
    }
}