package personal.walker.array;

import personal.walker.Solution;

import java.util.*;

public class LC763 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels("eccbbbbdec"));
    }


    public List<Integer> partitionLabels(String s) {
        int[][] charOccurs = new int[26][2];
        int startC = s.charAt(0);
        for (int i = 0; i < 26; i++) {
            charOccurs[i] = new int[]{1 << 31 - 1, 1 << 31 - 1};
        }
        //Arrays.fill(charOccurs, new int[]{-1, -1});
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charOccurs[c - 'a'][0] == 1 << 31 - 1) {
                charOccurs[c - 'a'][0] = i;
            }
            charOccurs[c - 'a'][1] = i;
        }
        Arrays.sort(charOccurs,Comparator.comparing(o -> o[0]));
        List<int[]> resultStack = new ArrayList<>();
        //resultStack.add(charOccurs[0]);
        int[] overlap = charOccurs[0];
        for (int i = 1; i < charOccurs.length && charOccurs[i][0] < 1 << 31 -1; i++) {
            // has overlap, need merge together
            if (overlap[1]  >= charOccurs[i][0]){
                overlap[1] = Math.max(charOccurs[i][1],overlap[1]);
            }else {
                //resultStack.remove(resultStack.size() - 1);
                // doesn't have overlap, add as a new one.
                resultStack.add(overlap);
                overlap = charOccurs[i];
                //resultStack.add(overlap);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int[] ints : resultStack) {
            result.add(ints[1] - ints[0] + 1);
        }
        return result;
    }
}
