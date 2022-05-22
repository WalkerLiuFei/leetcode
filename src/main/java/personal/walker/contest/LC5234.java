package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.*;

public class LC5234 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(removeAnagrams(new String[]{"abba","baba","bbaa","cd","cd"}));;
        System.out.println(removeAnagrams(new String[]{"a","b","c","d","e"}));;
    }

    /**
     * 找出数量不一致的即可
     * @param words
     * @return
     */
    public List<String> removeAnagrams(String[] words) {
         HashMap<Integer,List<int[]>> listHashMap = new HashMap<>();
        List<String> result = new ArrayList<>();
       // Gson gson = new Gson();
        result.add(words[0]);
        for(int i  = 1; i < words.length; i++){
            int[] charCount = new int[26];
            for (char c : words[i].toCharArray()){
                charCount[c - 'a'] ++;
            }

            int[] lastCharCount = new int[26];
            for (char c : words[i -1].toCharArray()){
                lastCharCount[c - 'a'] ++;
            }
            boolean flag = true;
            for (int j = 0; j < 26;j++){
                flag = lastCharCount[j] == charCount[j];
                if (!flag){
                    break;
                }
            }
            if (!flag){
                result.add(words[i]);
            }

        }
        return result;
    }
}
