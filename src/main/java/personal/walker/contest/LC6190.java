package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6190 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(goodIndices(new int[]{2,1,1,1,3,4,1},2));
//        System.out.println(goodIndices(new int[]{2,1,1,2},2));
//        System.out.println(goodIndices(new int[]{100,2,3,1,1,2},2));
//        System.out.println(goodIndices(new int[]{440043,276285,336957},1));
        System.out.println(goodIndices(new int[]{388589,17165,726687,401298,600033,537254,301052,151069,399955},4));
        System.out.println(goodIndices(new int[]{388589,17165,726687,401298,600033,537254,301052,151069,399955},2));

    }

    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 有序的
        int[] preDP = new int[nums.length];
        preDP[0] = 1;
        // 有序的
        int[] postDP = new int[nums.length];
        postDP[0] = 1;
        for (int i = 1; i < nums.length;i ++){
            if (nums[i] <= nums[i-1]){
                preDP[i] = preDP[i - 1]+1;
            }else {
                preDP[i] = 1;
            }
            if (nums[i] >= nums[i-1]){
                postDP[i] = postDP[i - 1]+1;
            }else {
                postDP[i] = 1;
            }
        }

        for (int i = k; i < nums.length - k; i++){
            if (k == 1){
                result.add(i);
                continue;
            }
            if (preDP[i - 1] >= k && postDP[i + k] >= k){
                result.add(i);
            }
        }
        return result;
    }

        /**
         * sliding window, 前k
         *
         */
    public List<Integer> goodIndices2(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        // 有序的
        LinkedList<Integer> preQueue = new LinkedList<>();
        // 有序的
        LinkedList<Integer> postQueue = new LinkedList<>();

        // 前序递增数组
        for (int i = 0 ; i < k; i++){
            if (preQueue.isEmpty() || nums[i] > preQueue.peekLast()){
                preQueue.add(nums[i]);
            }
        }
        // 后续的递减数组
        for (int i = k+1; i < nums.length; i++){
            if (postQueue.isEmpty() || nums[i] < postQueue.peekLast()){
                postQueue.add(nums[i]);
            }
        }

        for (int i = k; i < nums.length - k; i++){
            if (preQueue.size() < k && postQueue.size() < k){
                result.add(i);
            }
            preQueue.removeFirst();
            if (preQueue.isEmpty() || nums[i] > preQueue.peekLast()){
                preQueue.add(nums[i]);
            }
            postQueue.removeFirst();
            if ((i + k + 1) < nums.length && ((postQueue.isEmpty() ||   nums[i + k + 1] < postQueue.peekLast()))){
                postQueue.add(nums[i + k + 1]);
            }
         }
        return result;
    }
}
