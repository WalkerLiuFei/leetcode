package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC6186 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(smallestSubarrays(new int[]{8,4,2,1,0,8})));
        System.out.println(Arrays.toString(smallestSubarrays(new int[]{1,0,2,1,3})));
        System.out.println(Arrays.toString(smallestSubarrays(new int[]{1,2})));
        System.out.println(Arrays.toString(smallestSubarrays(new int[]{1,0})));
    }

    /**
     * 1,0,2,1,3
     * 1,1,3,3,3
     * <p>
     * <p>
     * 8,4,2,1,0,8
     * 15,15,11,9,8,8
     * 8,12,14,15,15,15
     *
     * @param nums
     * @return
     */
    public int[] smallestSubarrays(int[] nums) {
        // 或运算中，将所有的数都包含进去肯定是最大，我们要找的是，怎样不包含后面的数？
        // 将所有的或起来，如果数字不再变大，那么肯定的，就不需要了，
        //
        PriorityQueue<Integer>[] bitOccur = new PriorityQueue[32];
        for (int i = 0; i < 32;i++){
            bitOccur[i] = new PriorityQueue<>();
        }

        for (int i = 0; i < nums.length;i++) {
            int num = nums[i];
            for (int bit = 0; bit < 32 && num > 0; bit++) {
                if ((num & 0x01) == 1) {
                    bitOccur[bit].add(i);
                }
                num >>=1;
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length;i++){
            int lastBitOccurIndex = i;
            for (int bit = 0; bit < 32; bit++){
                if (!bitOccur[bit].isEmpty()){
                    if (bitOccur[bit].peek()> lastBitOccurIndex){
                        lastBitOccurIndex = bitOccur[bit].peek();
                    }
                }
            }
            result[i] = lastBitOccurIndex - i + 1;
            //remove
            int bitCount = 0;
            while (nums[i] > 0) {
                if ((nums[i] & 0x01) == 1) {
                    bitOccur[bitCount].remove();
                }
                nums[i] >>= 1;
                bitCount++;
            }
        }
        return result;
    }
}
