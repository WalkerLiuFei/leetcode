package personal.walker.contest;

import personal.walker.Solution;

public class LC6104 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countAsterisks("l|*e*et|c**o|*de|"));
        System.out.println(countAsterisks("iamprogrammer"));
        System.out.println(countAsterisks( "yo|uar|e**|b|e***au|tifu|l"));;
    }


    public int countAsterisks(String s) {
        boolean entered = false;
        int result = 0;
        for (byte b : s.getBytes()){
            if (b == '*' && !entered){
                result++;
            }else if (b == '|' ){
                entered = !entered;
            }
        }
        return result;
    }
}
