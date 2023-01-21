package personal.walker.contest;

import personal.walker.Solution;

public class LC6245 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int pivotInteger(int n) {
       for (int i = 1; i <= n; i ++){
           int a = 0;
           for (int j = 1; j <= i; j++ ){
               a+= j;
           }
           int b = 0;
           for (int x = i; x <= n; x++ ){
               b += x;
           }
           if (a == b){
               return i;
           }
       }

       return  -1;
    }

}
