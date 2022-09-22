package personal.walker.a.notes;

import personal.walker.Solution;

public class LC2381 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Shift {
        int start;
        int end;
        boolean forward;

        Shift(int start,
              int end,
              boolean forward) {
            this.start = start;
            this.end = end;
            this.forward = forward;
        }
    }

    class Split {
        int start;
        int end;
        int shift;

        Split(int _start, int _end, int _shift) {
            this.start = _start;
            this.end = _end;
            this.shift = _shift;
        }
    }

    /**
     * 利用差分数组
     * 注意到一个预订记录实际上代表了一个区间的增量。我们的任务是将这些增量叠加得到答案。因此，我们可以使用差分解决本题。
     *
     * 差分数组对应的概念是前缀和数组，对于数组 [1,2,2,4][1,2,2,4]，其差分数组为 [1,1,0,2][1,1,0,2]，
     * 差分数组的第 ii 个数即为原数组的第 i-1i−1 个元素和第 ii 个元素的差值，也就是说我们对差分数组求前缀和即可得到原数组。
     *
     * 差分数组的性质是，当我们希望对原数组的某一个区间 [l,r][l,r] 施加一个增量 inc 时，差分数组 dd 对应的改变是：d[l]d[l] 增加
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public String shiftingLetters(String s, int[][] shifts) {
        return "";
    }

}
