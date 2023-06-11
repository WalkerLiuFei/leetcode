package personal.walker.math;

import personal.walker.Solution;

public class LC6391 implements Solution {
    @Override
    public void runTestCases() {

    }
    public int sumOfMultiples(int n) {
        int result = 0;
        for (int count = 1; count <= n; count++){
            if (count % 3 == 0 || count % 5 == 0 || count % 7 == 0){
                result += count;
            }
        }
        return result;
    }
}
