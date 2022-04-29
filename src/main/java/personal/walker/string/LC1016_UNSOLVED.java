package personal.walker.string;

import personal.walker.Solution;

public class LC1016_UNSOLVED implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(queryString("0110",4));
        System.out.println(queryString("10010111100001110010",10));
        System.out.println(queryString("110101011011000011011111000000",15));

    }

    public boolean queryString(String s, int n) {
        StringBuilder nString = new StringBuilder();
        while (n > 0){
            if (n % 2 == 0){
                nString.append("0");
            }else {
                nString.append("1");
            }
            n = n / 2;
        }
        nString.reverse();
        System.out.println(nString);
        return s.contains(nString);
    }
}
