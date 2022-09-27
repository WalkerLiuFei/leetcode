package personal.walker.a.notes;

import personal.walker.Solution;

public class LC287 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
    //https://www.youtube.com/watch?v=UkKBPGt5Nok

    /**
     * 结合上面的link list,
     * 1 -> 3 -> 2 -> 4 -> 2
     */
    public int findDuplicate(int[] nums) {
        int slow = 0,fast = 0;
        while (true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast){
                break;
            }
        }
        fast = 0;
        while (fast != slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
