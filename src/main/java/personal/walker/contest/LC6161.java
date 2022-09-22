package personal.walker.contest;

import personal.walker.Solution;

public class LC6161 implements Solution {
    @Override
    public void runTestCases() {

    }
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        int star = 0;
        for (int i = s.length()-1; i >= 0 ; i--){
            if (s.charAt(i) == '*'){
                star++;
            }else if (star > 0){
                star--;
            }else {
                builder.append(s.charAt(i));
            }
        }
        return builder.reverse().toString();
    }

}
