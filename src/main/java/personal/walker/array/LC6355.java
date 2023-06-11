package personal.walker.array;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC6355 implements Solution {
    @Override
    public void runTestCases() {
   //   System.out.println(primeSubOperation(new int[]{998,2}));

        System.out.println(primeSubOperation(new int[]{5,8,3}));

    }



    public boolean primeSubOperation(int[] nums) {
        List<Integer> primes = getPrimes(1000);
        int last = 1 >> 30 - 1;
        for (int i = 0; i < nums.length;i++){
            int largestPrime = 0;
            for (int j = 0; j < primes.size(); j++){
                int prime = primes.get(j);
                if (!(nums[i] > prime && nums[i] - prime > last)){
                    break;
                }
                largestPrime = prime;
            }
            if (largestPrime == 0 && nums[i] <= last){
                return false;
            }
            nums[i] -= largestPrime;
            last = nums[i] ;
        }
        return true;
    }


    public static List<Integer> getPrimes(int x) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= x; num++) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(num);
            }
        }
        return primes;
    }

}
