package personal.walker.bit.operation;

import personal.walker.Solution;

public class LC6431 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        for (int originalZero = 0; originalZero <= 1; originalZero++) {
            int[] original = new int[n];
            original[0] = originalZero;
            for (int i = 0; i < n - 1; i++) {
                original[i + 1] = derived[i] ^ original[i];
            }
            if ((original[n - 1] ^ original[0])== derived[n - 1]) {
                return true;
            }
        }
        return false;
    }

}
