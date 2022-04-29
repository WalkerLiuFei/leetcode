package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC187 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 很简单的sliding window算法
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set seen = new HashSet(), repeated = new HashSet();
        for (int i = 0; i + 9 < s.length(); i++) {
            String ten = s.substring(i, i + 10);
            if (!seen.add(ten))
                repeated.add(ten);
        }
        return new ArrayList(repeated);
    }

}
