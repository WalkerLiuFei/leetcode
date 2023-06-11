package personal.walker.string;

import personal.walker.Solution;

public class LC6461 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(isFascinating(192));
    }


    public boolean isFascinating(int n) {
        String numStr = n + String.valueOf(n  * 2) + (n * 3);
        boolean[] mapper = new boolean[10];
        for (int i= 0 ; i < numStr.length();i++){
            int b = numStr.charAt(i) - '0';
            if (mapper[b] || b == 0){
                return false;
            }
            mapper[b] = true;
        }
        return true;
    }

}
