package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6279 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(distinctPrimeFactors(new int[]{2,4,3,7,10,6})); ;
        System.out.println(distinctPrimeFactors(new int[]{2,14,19,19,5,13,18,10,15,20}));;

    }


    public int distinctPrimeFactors(int[] nums) {
        Set<Integer> factors = new HashSet<>();
        // 从2开始遍历到该数的平方根
        for (int num : nums){
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if(!isPrime(i)){
                    continue;
                }
                // 如果该数是质数，则进行取余运算
                while (num % i == 0) {
                    // 将该数加入到质因数列表中
                    factors.add(i);
                    // 将该数除以这个因数
                    num /= i;
                }
            }
            if (num != 1){
                factors.add(num);
            }
        }
        return factors.size() + 1;
    }

    private boolean isPrime(int num){
        boolean isPrime = true;
        // 从2开始遍历到该数的平方根
        for (int i = 2; i <= Math.sqrt(num); i++) {
            // 如果该数是一个因数，则表明它不是质数
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

}
