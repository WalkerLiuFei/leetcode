package personal.walker.contest;

import personal.walker.Solution;

public class LC6234 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(subarrayLCM(new int[]{2, 6, 2, 7, 1}, 6));
        System.out.println(subarrayLCM(new int[]{2, 1, 1, 5}, 5));
    }

    public int subarrayLCM(int[] NUMS, int k) {
        int res = 0;
        for (int i = 0; i < NUMS.length; i++) {
            res += NUMS[i] == k ? 1 : 0;
        }

        for (int i = 0; i < NUMS.length; i++) {
             int j = i + 1;
            int lcm = NUMS[i];
             for (; j < NUMS.length; j++) {
                int x = lcm(lcm, NUMS[j]);
                if (x == k){
                   res++;
                }
                 if (x > k) {
                    break;
                }
                lcm = x;
            }

        }
        return res;
    }


    // 最大公约数
    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        a %= b;
        return gcd(b, a);
    }

    // 最小公倍数
    int lcm(int n1, int n2) {
        return n1 * n2 / gcd(n1, n2);
    }

}
