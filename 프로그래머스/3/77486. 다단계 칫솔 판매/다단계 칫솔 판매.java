import java.util.*;
class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> profit = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            parent.put(enroll[i], referral[i]);
            profit.put(enroll[i], 0);
        }

        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int money = amount[i] * 100;

            while (!name.contentEquals("-") && money > 0) {
                int charge = money / 10;
                int balance = profit.get(name);
                profit.put(name, balance + money - charge);
                name = parent.get(name);
                money = charge;
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++)
            answer[i] = profit.get(enroll[i]);
        return answer;
    }
}