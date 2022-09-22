package personal.walker.sliding.window;

import personal.walker.Solution;

public class LC424 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(characterReplacement("AABABBA",1));
//        System.out.println(characterReplacement("AABAXXXXXX",1));
//        System.out.println(characterReplacement("ABAB",2));
//        System.out.println(characterReplacement("ABAB",1));
//        System.out.println(characterReplacement("AB",1));
        System.out.println(characterReplacement("DSSMESSTR", 2));

    }

    public int characterReplacement(String s, int k) {
        int start = 0, end = 0;
        byte[] array = s.getBytes();
        // start 和 end 中间 每个 字符的数量
        int[] mem = new int[26];
        int result = 1;
         // 当前窗口内最多的单个字符的数量
        int maxCount = 0;
        for (; end < array.length; end++) {
            // 当前窗口内最多的单个字符的数量
            maxCount = Math.max(maxCount, ++mem[array[end] - 'A']);
            // 如果当前窗口的数量变换次数已经大于k
            while ( end - start + 1 - maxCount> k) {
                mem[array[start++] - 'A']--;
            }
            result = Math.max(end - start + 1, result);
        }
        return result;
    }
}
