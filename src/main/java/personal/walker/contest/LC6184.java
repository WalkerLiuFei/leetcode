package personal.walker.contest;

import personal.walker.Solution;

public class LC6184 implements Solution {
    @Override
    public void runTestCases() {
       System.out
               .println(countDaysTogether("08-15",
                       "08-18",
                       "08-16",
                       "09-19"));
        System.out
                .println(countDaysTogether("10-01",
                        "10-31",
                        "11-01",
                        "12-31"));
        System.out
                .println(countDaysTogether("04-20",
                        "06-18",
                        "04-12",
                        "12-19"));
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String greaterArrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String smallerLeave = leaveBob.compareTo(leaveAlice) < 0 ? leaveBob : leaveAlice;
        if (smallerLeave.compareTo(greaterArrive) < 0){
            return 0;
        }
        String[] arriveParts =  greaterArrive.split("-");
        int arriveMonth = Integer.parseInt(arriveParts[0]);
        int arriveDay = Integer.parseInt(arriveParts[1]);

        String[] leaveParts =  smallerLeave.split("-");
        int leaveMon = Integer.parseInt(leaveParts[0]);
        int leaveDay = Integer.parseInt(leaveParts[1]);
        if (leaveMon == arriveMonth){
            return leaveDay - arriveDay + 1;
        }
        // arrive month left
        int result = monthDays[arriveMonth - 1] - arriveDay + leaveDay;
        for (int i = arriveMonth ; i < leaveMon - 1; i++){
            result += monthDays[i];
        }
        return result + 1;
    }
}
