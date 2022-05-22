package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC5299 implements Solution {
    @Override
    public void runTestCases() {
      System.out.println( divisorSubstrings(240,2));
        System.out.println( divisorSubstrings(430043,2));
        System.out.println( divisorSubstrings(0000,2));

        System.out.println( divisorSubstrings(989831931,2));
        System.out.println( divisorSubstrings(989831931,3));
        System.out.println( divisorSubstrings(989831931,4));
    }
    public int divisorSubstrings(int num, int k) {
        String numStr = Integer.toString(num);
        int ans = 0;
        for (int i = 0, j = k - 1; j < numStr.length(); j++,i++){
           int divisor =  Integer.parseInt(numStr.substring(i,j+1));
           if (divisor == 0){
               continue;
           }
           //System.out.println(divisor);

           if (num % divisor == 0){
               ans++;
           }
        }
        return ans;
    }

}
