package personal.walker.array;

import personal.walker.Solution;

public class LC985 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int initialValue = 0;
        for (int num : nums) {
            if ((num & 0x01) == 0) {
                initialValue += num;
            }
        }
        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length;i++) {
            int[] query = queries[i];
            int src = nums[query[1]];
            boolean srcEven = (src & 0x01) == 0;
            nums[query[1]] += query[0];
            // 原来是偶数
            if (srcEven) {
                initialValue -= src;
            }
            if ((nums[query[1]] & 0x01) == 0){
                initialValue += nums[query[1]];
            }
            result[i] = (initialValue);
        }
        return result;
    }

}
