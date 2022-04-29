package personal.walker.math;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Stack;

public class LC1317 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson  = new Gson();
        System.out.println(gson.toJson(getNoZeroIntegers(100)));
        System.out.println(gson.toJson(getNoZeroIntegers(3124)));
        System.out.println(gson.toJson(getNoZeroIntegers(3131)));
        System.out.println(gson.toJson(getNoZeroIntegers(800)));
        System.out.println(gson.toJson(getNoZeroIntegers(1234)));
    }

    /**
     * 100 - 99
     *
     * @param n
     * @return
     */

    public int[] getNoZeroIntegers(int n) {
        // 允许结果为 -1
        Stack<Integer> aNumStack = new Stack<>();

        for (int a = 1; a < n; a++) {
            if (hasZero(a)) {
                continue;
            }
            if (!hasZero(n - a)) {
                return new int[]{a, n - a};
            }
        }
        return null;
    }

    private boolean hasZero(int n) {
        while (n % 10 != 0) {
            n = n / 10;
        }
        return n != 0;
    }
//    List<Integer> aNums = new ArrayList<>();
//    List<Integer> bNums = new ArrayList<>();
//    // 判断进位
//    public boolean recursive(List<Integer> nNums,int i, int a,int carry){
//        if (nNums.get(i) - a == 0 && bNums.size() > 0){
//            return false;
//        }
//        int candidate = 1;
//        if (aNums.size() == 0){
//            candidate = 0;
//        }
//        for (;candidate < 10; candidate++ ){
//            if (recursive(nNums,i+1,candidate,)){
//
//            }
//        }
//    }
}
