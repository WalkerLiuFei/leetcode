package personal.walker.string;

import personal.walker.Solution;

public class LC859 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(buddyStrings("ab","ba"));
//        System.out.println(buddyStrings("bacd","abdc"));
        System.out.println(buddyStrings("accccd","dcccca"));
    }


    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()){
            return false;
        }
        int[] lowercases = new int[26];
        boolean existDouble = false;
        int gotResult = 0;
        for (int i = 0;  i < s.length(); i++ ){
            if (s.charAt(i) != goal.charAt(i)){
                char sTarget = goal.charAt(i);
                char goalTarget = s.charAt(i);
                gotResult++;
                int j = i + 1;
                for (; j < s.length();j++){
                    if (s.charAt(j) != goal.charAt(j)){
                        if (s.charAt(j) == sTarget && goal.charAt(j) == goalTarget && gotResult == 1){
                            gotResult++;
                        }else {
                            return false;
                        }
                    }
                }
                i = j;
            }
            if (i < s.length()){
                lowercases[s.charAt(i) - 'a']++;
                if (lowercases[s.charAt(i) - 'a'] > 1){
                    existDouble = true;
                }
            }

        }
        return (gotResult == 0 && existDouble) || gotResult == 2;
    }
}
