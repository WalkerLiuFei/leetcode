package personal.walker.contest;

import personal.walker.Solution;

public class LC6284 implements Solution {
    @Override
    public void runTestCases() {
//         System.out.println(isItPossible("a", "abc"));
//        System.out.println(isItPossible("ab", "abc"));
//        System.out.println(isItPossible("abcc", "aab"));
//        System.out.println(isItPossible("abcde", "fghij"));
//        System.out.println(isItPossible("a", "bb"));
//        System.out.println(isItPossible("aa", "bbcc"));
//        System.out.println(isItPossible("aab", "bccd"));
//        System.out.println(isItPossible("ab", "abcc"));
        //System.out.println(isItPossible("az", "z"));
        // System.out.println(isItPossible("buebek", "ukuk"));
        System.out.println(isItPossible("ikaflbdajfhkdcjmfhoddbnkdflejhofekknfhbfkdibegkejijefgocnakbdahhhbbilmflhmkk",
                "nlfommedklmgjcijamgddfkkgfkehimmbchflbneekeeggaiexaambkdkncghiedijkljblilefgmjiilbdkkgfmbobf"));

    }

    /**
     * 4   2
     * abcxxx acxx
     * abc abb
     * case 1 :
     * 1. word1 - word2 = 1, word 1 有word2 没有的字符且word2 中的一个多个字符数量 word1 有可以交换
     * 2. word1 == word2 ， word1 和word2 长度不相同但是有相同的字符，长度相同
     * 3. word1 - word == 2, word1 有word2 不包含的字符，且word2的字符 word1 全都有,且这个字符word1 只能有一个
     */

    public boolean isItPossible(String word1, String word2) {
        int[] word1Chars = new int[26];
        int count1 = 0;

        int[] word2Chars = new int[26];
        int count2 = 0;
        for (char c : word1.toCharArray()) {
            if (word1Chars[c - 'a'] == 0) {
                count1++;
            }
            word1Chars[c - 'a']++;
        }

        for (char c : word2.toCharArray()) {
            if (word2Chars[c - 'a'] == 0) {
                count2++;
            }
            word2Chars[c - 'a']++;
        }
        int diff = count1 - count2;
        if (Math.abs(diff) > 2) {
            return false;
        }
        if (count1 == count2) {
            if (word1.length() == 1) {
                return word2.length() == 1;
            }
            if (word2.length() == 1) {
                return word1.length() == 1;
            }
            return true;
        }
        if (diff < 0) {
            int[] tmp = word1Chars;
            word1Chars = word2Chars;
            word2Chars = tmp;
        }
        switch (Math.abs(diff)) {
            case 1:
                return case1(word1Chars,word2Chars) || case2(word1Chars,word2Chars);
            case 2:
                return case3(word1Chars,word2Chars);
            default:
                return false;
        }
     }

    private boolean case3(int[] charArray1,int[] charArray2 ){
        boolean flag = false;
        int targetIndex = -1;
        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] == 1 && charArray2[i] == 0) {
                targetIndex = i;
                flag = true;
            }
        }
        if (!flag) {
            return false;
        }
        flag = false;
        for (int i = 0; i < charArray2.length; i++) {
            if (charArray2[i] > 1 && charArray1[i] > 0 && i != targetIndex) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    private boolean case1(int[] charArray1,int[] charArray2 ){
        boolean flag = false;
        for (int i = 0; i < charArray1.length; i++){
            if (charArray1[i] > 1 && charArray2[i] == 0) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            return case2(charArray1,charArray2);
        }
        flag = false;
        for (int i = 0; i < charArray2.length; i++){
            if (charArray2[i] > 1 && charArray1[i] > 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    private boolean case2(int[] charArray1,int[] charArray2 ){
        boolean flag = false;
        for (int i = 0; i < charArray1.length; i++){
            if (charArray2[i] == 0 && charArray1[i] == 1) {
                flag = true;
                break;
            }
        }
        if (!flag){
            return false;
        }
        flag = false;
        for (int i = 0; i < charArray2.length; i++){
            if (charArray2[i] == 1 && charArray1[i] > 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}


