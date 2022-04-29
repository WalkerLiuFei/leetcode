package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.Stack;

//https://leetcode.com/problems/jump-game-vii/
public class LC1871 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * dp + sliding window.
     * 1. 这是一个自下而上的 DP 实现。布尔值表示该位置是否可以从开始到达。所以第一步是生成表。
     *    在这里，表格被预先标记为 True 或 False，因此“1”已经被标记为 False。
     * 2. 要确定 dp[i] 的状态，需要检查窗口 dp[i-maxJ : i-minJ] 中的状态，因为如果标记为 True，它们中的任何一个都可以到达 i。
     * 3. 然后你需要检查这个窗口中是{否有一个 True} 。注意这是一个滑动窗口问题，所以不需要每次都计算,
     *      只需要从 dp[i-maxJ-1] 中删除效果并添加 dp[i-minJ]。这是通过这两行代码 pre += dp[i - minJ] 和 pre -= dp[i - maxJ - 1] 完成的
     * 4. if i >= minJ: 和 if i > maxJ: 的 if 语句处理初始边界。
     *
     *
     *     public boolean canReach(String s, int minJ, int maxJ) {
     *         int n = s.length(), pre = 0;
     *         boolean[] dp = new boolean[n];
     *         dp[0] = true;
     *         for (int i = 1; i < n; ++i) {
     *             if (i >= minJ && dp[i - minJ])
     *                 pre++;
     *             if (i > maxJ && dp[i - maxJ - 1])
     *                 pre--;
     *             dp[i] = pre > 0 && s.charAt(i) == '0';
     *         }
     *         return dp[n - 1];
     *     }
     * if i > j  : i + minJump > j + minJump
     * @param s
     * @param minJump
     * @param maxJump
     * @return
     */
    class Pair {
        int front;
        int end;
        Pair(int front,int end){
           this.front = front;
           this.end = end;
        }
    }
    public boolean canReach(String s, int minJump, int maxJump) {
        byte[] sBytes = s.getBytes();
        if (sBytes[s.length() - 1] != '0'){
            return false;
        }
        boolean[] dp = new boolean[sBytes.length];
        dp[0] =true;

        return false;
    }
}
