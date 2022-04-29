package personal.walker.top.like;

import java.util.Arrays;

public class LC204 {

    public void runTestCases(){
        System.out.println(countPrimes(10));
        System.out.println(countPrimes(100));
        System.out.println(countPrimes(1000));

    }
    /**
     * 素数筛，从2，3开始进行染色，如果
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] isNotPrime = new boolean[n];
        //Arrays.fill(isNotPrime,true);
        for (int i = 2; i < n;i ++){
            if (isNotPrime[i]){
                continue;
            }
            for (int j = i  * 2 ; j < n;j += i){
                isNotPrime[j] = true;
            }
        }
        int result = 0;
        for (int i = 2;i < n;i++){
            if (!isNotPrime[i]){
                result++;
            }
        }
        return result;
    }

    public int countPrimes2(int n) {
        boolean[] isNotPrime = new boolean[n];
        //Arrays.fill(isNotPrime,true);
        for (int i = 2; i < n;i ++){
            if (isNotPrime[i]){
                continue;
            }
            for (int j = i  * 2 ; j < n;j += i){
                isNotPrime[j] = true;
            }
        }
        int result = 0;
        for (int i = 2;i < n;i++){
            if (!isNotPrime[i]){
                result++;
            }
        }
        return result;
    }

}
