package personal.walker.bit.operation;

import personal.walker.Solution;

public class LC476 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(findComplement(5));
       System.out.println(5 ^ 7);
    }

    public int findComplement(int num) {
        int  save = num;
        int helper =  0x0;
        while (num != 0){
            num >>= 1;
            helper = (helper << 1) + 1;
        }
         return  save ^ helper;
    }
}
