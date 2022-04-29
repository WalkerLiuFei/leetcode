package personal.walker.top.like;

public class LC3 {
    /**
     * 思路 ：Sliding window算法
     * 1. 利用一个mapper < character , int > 记录最近的这个无冲突字符串所有的字符的未知
     * 2. abcbabcbb :
     * 1. 期初 noConflictStartPosition = 0,maxLength = 1;
     * 2.
     * abcabcbb
     * 1. a 初始 是a
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 1;
        byte[] bytes = s.getBytes();
        // 最近的，没有冲突的位置
        int conflictNextPosition = 0;
        // 当前无冲突字符串长度
        // can be replaced by [128]int 数组。
        int[] mapper = new int[128];
        for (int i = 0; i < bytes.length; i++) {
            byte b = bytes[i];
            // 有冲突, 拿到这个冲突的
            if (mapper[b] > conflictNextPosition) {
                conflictNextPosition = mapper[b];
            }
            if (i - conflictNextPosition + 1 > maxLength) {
                maxLength = i - conflictNextPosition + 1;
            }

            mapper[b] = i + 1;
        }
        return maxLength;
    }
}
