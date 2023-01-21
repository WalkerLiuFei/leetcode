package personal.walker.contest;

import personal.walker.Solution;

public class LC6224 implements Solution {
    @Override
    public void runTestCases() {
        //System.out.println(subarrayGCD(new int[]{3,12,9,6},3));
      //  System.out.println(subarrayGCD(new int[]{3,3,4,1,2},1));
        System.out.println(subarrayGCD(new int[]{15,11,5,19,9,9,4},1));
    }

    public int subarrayGCD(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                result++;
            }
            if (i == nums.length - 1){
                break;
            }
            int gcd =  nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                gcd = getGCD(gcd, nums[j]);
                if (gcd == k){
                    result++;
                    System.out.printf("%d,%d\n",i,j);
                }
            }
        }
        return result;
    }

    int getGCD(int a, int b) {
        if(b == 0){
            return a;
        }
        a %= b;
        return getGCD(b, a);
    }
}
