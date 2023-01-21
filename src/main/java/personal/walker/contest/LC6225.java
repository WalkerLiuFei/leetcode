package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashMap;

public class LC6225 implements Solution {
    @Override
    public void runTestCases() {

    }
    public String oddString(String[] words) {
        int[][] differenecs = new int[words.length][words[0].length() - 1];
        //HashMap<int[],Integer> map = new HashMap<>();
        for (int i =0; i < words.length; i++){
            for (int j = 1; j < words[0].length();j++){
                differenecs[i][j - 1] = words[i].charAt(j) - words[i].charAt(j-1);
            }
        }
        for(int i = 1; i < differenecs.length; i ++){
            if (!Arrays.equals(differenecs[i],differenecs[i - 1])){
                if (i == differenecs.length - 1 || !Arrays.equals(differenecs[i],differenecs[i + 1])){
                    return words[i];
                }
                return words[i-1];
            }
        }
        return "";
    }


}
