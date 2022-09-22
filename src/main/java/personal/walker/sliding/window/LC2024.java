package personal.walker.sliding.window;

import personal.walker.Solution;

public class LC2024 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maxConsecutiveAnswers("TFFT",1));
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        byte[] array = answerKey.getBytes();
        int start = 0;
        int end = 0;
        int trueCount = 0;
        int falseCount = 0;
        int result = 0;
        while (end < array.length) {
            if (array[end] == 'T') {
                trueCount++;
            }
            if (array[end] == 'F') {
                falseCount++;
            }
            int windowSize = end - start + 1;
            if (windowSize - Math.min(trueCount, falseCount) > k) {
                if (array[start] == 'T') {
                    trueCount--;
                }
                if (array[start] == 'F') {
                    falseCount--;
                }
                start++;
            }

            result = Math.max(end - start + 1, result);
            end++;
        }
        return result;
    }
}
