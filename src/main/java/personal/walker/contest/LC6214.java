package personal.walker.contest;

import personal.walker.Solution;

public class LC6214 implements Solution {
    @Override
    public void runTestCases() {

    }
    public boolean haveConflict(String[] event1, String[] event2) {
        if (event1[0].equals(event2[0]) || event1[0].equals(event2[1]) ||  event1[1].equals(event2[0]) || event1[1].equals(event2[1])){
            return true;
        }
        // 1 开始早于 2 或同时开始
        if (event1[0].compareTo(event2[0]) < 0){
            return event1[1].compareTo(event2[0]) >= 0;
        }
        // 2 早于1 开始
        if (event1[0].compareTo(event2[0]) > 0){
            return event2[1].compareTo(event1[0]) >= 0;
        }
        return false;
    }
}
