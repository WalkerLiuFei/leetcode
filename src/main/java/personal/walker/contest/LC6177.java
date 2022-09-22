package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6177 implements Solution {
    @Override
    public void runTestCases() {
      System.out.println(partitionString("abacaba"));
       System.out.println(partitionString("aaa"));
       System.out.println(partitionString("ssssss"));

    }

    /**
     * Sliding window
     * @param s
     * @return
     */
    public int partitionString(String s) {
        int[] currentOccurMap = new int[26];
        Arrays.fill(currentOccurMap,-1);

        int result = 0;
        for (int i = 0; i < s.length();){
            currentOccurMap[s.charAt(i) - 'a'] = i;
            int j = i + 1;
            for (;j < s.length(); j++){
                if (currentOccurMap[s.charAt(j) - 'a'] != -1){
                    break;
                }
                currentOccurMap[s.charAt(j) - 'a'] = j;
            }
            result++;
            i = j;
            Arrays.fill(currentOccurMap,-1);
        }
        return result;
    }
}
