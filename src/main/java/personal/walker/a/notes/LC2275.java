package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LC2275 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(16 & 17 & 62);
    }

    /**
     * 既然要求按位与（&）大于 0, 那么一定存在某一位多个数都为 1
     * 统计 32 位上哪一位出现的个数最多,那么这几个数 按位与 则大于0
     * @param candidates
     * @return
     */
    public int largestCombination(int[] candidates) {
        int[] cnt = new int[32];
        int max = 0;
        for (int c : candidates) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & c) > 0) cnt[i]++;
            }
        }
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }

}
