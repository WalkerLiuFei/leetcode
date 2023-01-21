package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC6266 implements Solution {
    @Override
    public void runTestCases() {
         System.out.println(smallestValue(15));
        System.out.println(smallestValue(4)); ;

    }


    public int smallestValue(int n) {

        while (true) {
            List<Integer> facs = new ArrayList<>();
            int x = 2;
            int nValue = n;
            while (nValue > 1) {
                while (nValue % x == 0 && nValue > 1) {
                    facs.add(x);
                    nValue /= x;
                }
                x += 1;
            }
            if (facs.size() <= 1){
                break;
            }
            int temp = 0;
            for (int factor : facs) {
                temp += factor;
            }
            if (temp == n){
                break;
            }
            n =temp;
        }
        return n;
    }



}
