import java.util.*;
public class Main {
    public static int baseMinutes;
    public static int baseFee;
    public static int unitMinutes;
    public static int unitFee;
    public int[] solution(int[] fees, String[] records) {
        baseMinutes = fees[0];
        baseFee = fees[1];
        unitMinutes = fees[2];
        unitFee = fees[3];

        SortedMap<String, Integer> feeList = new TreeMap<>();

        SortedMap<String, int[]> map = new TreeMap<>();
        for(String record : records) {
            String[] string3 = record.split(" ", 3);
            if(map.containsKey(string3[1])) {
                if(string3[2].contentEquals("IN"))
                    map.replace(string3[1], new int[]{map.get(string3[1])[0] - getMinutesByString(string3[0]), map.get(string3[1])[1] + 1});
                else
                    map.replace(string3[1], new int[]{map.get(string3[1])[0] + getMinutesByString(string3[0]), map.get(string3[1])[1] + 1});
            }

            else
                map.put(string3[1], new int[]{-getMinutesByString(string3[0]), 1});
        }
        return map.values().stream()
                .mapToInt(arr -> arr[1] % 2 == 1
                        ? arr[0] + getMinutesByString("23:59")
                        : arr[0])
                .map(minutes -> getFee(minutes))
                .toArray();
    }

    private int getMinutesByString(String time) {
        int timeHours = Integer.parseInt(time.split(":")[0]);
        int timeMinutes = Integer.parseInt(time.split(":")[1]);
        return (timeHours * 60) + timeMinutes;
    }

    private int getFee(int parkingMinutes) {
        if(parkingMinutes <= baseMinutes) return baseFee;
        int remainMinutes = parkingMinutes - baseMinutes;
        int remainUnit = (remainMinutes + unitMinutes - 1) / unitMinutes;
        return baseFee + (remainUnit * unitFee);
    }
}