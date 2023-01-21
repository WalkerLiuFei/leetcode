package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC6280 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(closestPrimes(18,72)));;
    }


    public int[] closestPrimes(int left, int right) {
        List<Integer> primes = new ArrayList<>();

         boolean[] isPrime = new boolean[right + 1];
        Arrays.fill(isPrime, true);

        // 从2开始遍历到 sqrt(n)
        for (int i = 2; i <= Math.sqrt(right); i++) {
            // 如果 isPrime[i] 为 true，则将 i 的倍数的 isPrime 值设为 false
            if (isPrime[i]) {
                for (int j = i * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        isPrime[1] = false;
        for (int num = left; num <= right;num++){
            if (isPrime[num]){
                primes.add(num);
            }
        }
        if (primes.size() < 2){
            return new int[]{-1,-1};
        }

        //HashMap<Integer,int[]> map = new HashMap<>();
        int smallest = primes.get(1) - primes.get(0);
        int[] result = new int[]{primes.get(0),primes.get(1)};
        for (int i =0; i < primes.size() - 1; i++){
            if (primes.get(i + 1) - primes.get(i) >= smallest){
                continue;
            }
            result[0] = primes.get(i);
            result[1] = primes.get(i + 1);
            smallest = result[1] - result[0];
        }
        return result;
    }


}
