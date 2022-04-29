package personal.walker.string;

import personal.walker.Solution;

import java.util.*;

public class LC345 implements Solution {
    @Override
    public void runTestCases() {

    }

    public String reverseVowels(String s) {
        byte[] sBytes = s.getBytes();
        HashSet vowels = new HashSet(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < s.length(); i++){
            if (vowels.contains(s.charAt(i))){
                indexes.add(i);
            }
        }
        for (int i = 0,j = indexes.size() - 1;  i < j; i++,j--){
            byte tmp = sBytes[i];
            sBytes[i] = sBytes[j];
            sBytes[j] = tmp;
        }
        return new String(sBytes);
    }
}
