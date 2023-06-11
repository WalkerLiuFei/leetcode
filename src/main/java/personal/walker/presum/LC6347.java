package personal.walker.presum;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC6347 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        // prefix sum
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int[] prefixSum = new int[words.length];
        if (vowelSet.contains(words[0].charAt(0)) && vowelSet.contains(words[0].charAt(words[0].length() - 1))) {
            prefixSum[0] = 1;
        }
        for (int i = 1; i < words.length; i++) {
            prefixSum[i + 1] =  vowelSet.contains(words[i].charAt(0)) && vowelSet.contains(words[i].charAt(words[i].length() - 1)) ?
                    prefixSum[i + 1] += prefixSum[i] + 1 : prefixSum[i];

        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i ++){
            if (queries[i][0] == 0){
                result[i] = prefixSum[queries[i][1]];
            }else {
                result[i] = prefixSum[queries[i][1]] - prefixSum[queries[i][0] - 1];
            }
        }
        return result;
    }

}
