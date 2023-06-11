package personal.walker.string;

import personal.walker.Solution;

public class LC6375 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 我们可以使用两个变量 insertions 和 countA 来记录插入字符的数量和当前未匹配的字母 'a' 的数量。
     * 遍历字符串 word，对于每个字符，分别执行以下操作：
     * 如果是字母 'a'，将 countA 加 1，然后继续下一个字符。
     * 如果是字母 'b'，如果下一个字符不是 'c'，则需要插入一个 'a'，将 insertions 加 1，否则直接跳过两个字符。
     * 如果是字母 'c'，如果当前未匹配的 'a' 的数量大于 0，则将 countA 减 1，然后继续下一个字符。如果当前未匹配的 'a' 的数量等于 0，
     * 需要根据下一个字符的情况来插入字符。如果下一个字符不是 'c'，则需要插入两个 'a' 和一个 'c'，将 insertions 加 2，然后继续下一个字符。
     * 如果下一个字符是 'c'，则需要插入一个 'a'，将 insertions 加 1，并将 countA 加 1，然后跳过两个字符。
     * 遍历结束后，我们还需要将剩余的未匹配的 'a' 插入到字符串中，插入的字符为两个 'c'，将 insertions 加上 countA 的两倍即可。
     * @param word
     * @return
     */

    public int addMinimum(String word) {
        int insertions = 0;
        int countA = 0;
        int countC = 0;
        int i = 0;
        while (i < word.length()) {
            char c = word.charAt(i);
            if (c == 'a') {
                countA++;
                i++;
            } else if (c == 'b') {
                if (i == 0 || word.charAt(i - 1) != 'a'){
                    insertions++;
                }else {
                    countA--;
                }
                if (i == word.length() - 1 || word.charAt(i + 1) != 'c') {
                    insertions++;
                    i++;
                } else {
                    // validate,continue.
                    i += 2;
                }
            } else if (c == 'c') {
                if (i > 0 && word.charAt(i) == 'a' ) {
                    // 补b
                    countA--;
                    insertions++;
                    i++;
                }else {
                    // standalone 'C'
                    countC++;
                }
            }
        }
        insertions += countA * 2 + countC * 2;
        return insertions;
    }
}
