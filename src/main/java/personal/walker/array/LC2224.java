package personal.walker.array;

import personal.walker.Solution;

public class LC2224 implements Solution {
    public int convertTime(String current, String correct) {
        String[] parts1 = current.split(":");
        Integer currentMinutes = Integer.parseInt(parts1[0].trim()) * 60 +  Integer.parseInt(parts1[1].trim());
        parts1 = correct.split(":");
        Integer correctMinutes = Integer.parseInt(parts1[0].trim()) * 60 +  Integer.parseInt(parts1[1].trim());
        Integer diff = correctMinutes - currentMinutes;
        int count = 0;
        count += diff / 60;
        diff -= (diff / 60) * 60;
        count += diff / 15;
        diff -= (diff / 15) * 15;
        count += diff / 5;
        diff -= (diff / 5) * 5;
        return count += diff;
    }

    @Override
    public void runTestCases() {
       System.out.println(convertTime("02:30","04:35"));;
        System.out.println(convertTime("02:30","02:30"));;
        System.out.println(convertTime("02:30","23:29"));;
        System.out.println(convertTime("09:41","10:34"));;
    }
}