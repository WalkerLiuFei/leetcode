package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6356 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.deepToString(substringXorQueries("101101", Util.convertTwoDimensionToIntegerArray("[[0,5],[1,2]]"))));
        System.out.println(Arrays.deepToString(substringXorQueries("0101", Util.convertTwoDimensionToIntegerArray("[[12,8]]"))));

    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = s.length();
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] ^ (s.charAt(i - 1) - '0');
        }
        int[][] ans = new int[queries.length][2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            if (!map.containsKey(pre[i])) {
                map.put(pre[i], new ArrayList<>());
            }
            map.get(pre[i]).add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            if (!map.containsKey(x ^ y)) {
                ans[i] = new int[]{-1, -1};
            } else {
                int left = n;
                int right = -1;
                for (int j : map.get(x ^ y)) {
                    if (j > y) break;
                    if (j >= x) {
                        left = Math.min(left, j);
                        right = Math.max(right, j);
                    }
                }
                if (right == -1) {
                    ans[i] = new int[]{-1, -1};
                } else {
                    ans[i] = new int[]{left, right - 1};
                }
            }
        }
        return ans;

        }


}
