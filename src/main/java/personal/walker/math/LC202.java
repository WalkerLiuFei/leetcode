package personal.walker.math;

import personal.walker.Solution;

import java.util.HashSet;

public class LC202 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(isHappy(2));
        System.out.println(isHappy(12));
        System.out.println(isHappy(32));
        System.out.println(isHappy(13));
        System.out.println(isHappy(9));
        System.out.println(isHappy(7));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (true){
            int sum = 0;
            while (n != 0){
                int part = n % 10;
                sum += part * part;

                n = n / 10;
            }
            if (sum == 1){
                return true;
            }
            if (hashSet.contains(sum)){
                return false;
            }
            hashSet.add(sum);
            n = sum;
        }
    }

}
