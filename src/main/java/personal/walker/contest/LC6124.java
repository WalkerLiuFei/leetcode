package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashSet;
import java.util.Set;

public class LC6124 implements Solution {
    @Override
    public void runTestCases() {

    }

    public char repeatedCharacter(String s) {
         Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            if (set.contains(c)){
                return c;
            }
            set.add(c);
        }
        return 'x';
    }


}
