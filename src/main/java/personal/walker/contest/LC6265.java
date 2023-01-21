package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC6265 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int similarPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length; i++){
            Set<Character> set = new HashSet<>();
            for (char c : words[i].toCharArray()){
                set.add(c);
            }
            int j = i +1;
            while (j < words.length){
                boolean flag = true;
                Set<Character> anotherSet = new HashSet<>();
                for (char c : words[j].toCharArray()){
                    if (!set.contains(c)){
                        flag = false;
                    }
                    anotherSet.add(c);
                    if (!flag){
                        break;
                    }
                }
                flag = flag && set.size() == anotherSet.size();
                if (flag){
                    result++;
                }
                j++;
            }
        }
        return result;
    }
}
