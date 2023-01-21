package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

public class LC6269 implements Solution {
    @Override
    public void runTestCases() {
        //  System.out.println(closetTarget(new String[]{"hello","i","am","leetcode","hello"},"hello",1));;
        System.out.println(closetTarget(new String[]{"i", "eat", "leetcode"}, "ate", 0));
        ;
        //   System.out.println(closetTarget(new String[]{"a","b","leetcode"},"leetcode",0));;
    }

    public int closetTarget(String[] words, String target, int startIndex) {
        if (words[startIndex].equals(target)){
            return 0;
        }
        int right = 0;
        boolean flag = false;
        int i = startIndex + 1;
        while (true) {
            if (i == words.length) {
                i = 0;
            }
            if (i == startIndex) {
                break;
            }
            right++;
            if (words[i].equals(target)) {
                flag = true;
                break;
            }
            i++;
        }
        i = startIndex - 1;
        int left = 0;
        while (true) {
            if (i == -1) {
                i = words.length - 1;
            }
            if (i == startIndex) {
                break;
            }
            left++;
            if (words[i].equals(target)) {
                flag = true;
                break;
            }
            i--;
        }
        if (!flag) {
            return -1;
        }
        return Math.min(right, left);
    }
}
