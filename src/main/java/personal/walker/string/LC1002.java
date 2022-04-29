package personal.walker.string;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC1002 implements Solution {

    @Override
    public void runTestCases() {

    }

    public List<String> commonChars(String[] words) {
        // existCount = words.length is avaliable result
        int[] existCount = new int[26];
        for (byte b : words[0].getBytes()){
            existCount[b-'a']++;
        }
        for (String word : words){
            int[] counted = new int[26];
            for (byte b : word.getBytes()){
                counted[b - 'a']++;
            }
            for (int i =0; i < 26;i++){
                if (counted[i] < existCount[i]){
                    existCount[i] = counted[i];
                }
            }
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++){
            if (existCount[i] ==0 ){
                continue;
            }
            while (existCount[i] > 0){
                result.add(Character.valueOf((char) (i +  'a')).toString());
                existCount[i]--;
            }
        }
        return result;
    }
}

