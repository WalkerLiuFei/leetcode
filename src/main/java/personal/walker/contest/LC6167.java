package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6167 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean checkDistances(String s, int[] distance) {
        int[] lastAppear = new int[26];
        Arrays.fill(lastAppear,-1);
        for (int i = 0; i < s.length();i++){
            char c = s.charAt(i);
           if ( lastAppear[c - 'a'] != -1){
               if (distance[c-'a']  != i - lastAppear[c - 'a'] - 1){
                   return false;
               }
           }
           lastAppear[c - 'a'] = i;
        }
        return true;
    }
}
