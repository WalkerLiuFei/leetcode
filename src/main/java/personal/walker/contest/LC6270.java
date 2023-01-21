package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

public class LC6270 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(takeCharacters("aabaaaacaabc", 2));
//        System.out.println(takeCharacters("abc", 1));
        System.out.println(takeCharacters("cbbac", 1));

    }

    /**
     * 如果 left start is the same as right start compare which is smaller to take the next character to satisfy
     *
     * @param s
     * @param k
     * @return
     */
    public int takeCharacters(String s, int k) {
        int i = 0, j = s.length() - 1;
        int result = 0;
        int[] nums = new int[3];
        while (i <= j && !isFull(nums,k)) {
            int tmpI = i;
            while (tmpI <= j && nums[s.charAt(tmpI) - 'a']  >= k){
                tmpI++;
            }
            int resultI = 1 << 31 -1;

            if (tmpI <= j){
                resultI = tmpI - i + 1;
            }
            int tmpJ = j;
            while (tmpJ >= i && nums[s.charAt(tmpJ) - 'a']  >= k){
                tmpJ--;
            }
            int resultJ = 1 << 31 -1;
            if (tmpJ >= i){
                resultJ = j - tmpJ + 1;
            }
            if (resultJ >= resultI){
                nums[s.charAt(tmpI )- 'a']++;
                i = tmpI + 1;
                result += resultI;
            }else {
                nums[s.charAt(tmpJ )- 'a']++;
                j = tmpJ - 1;
                result += resultJ;
            }
        }
        if (!isFull(nums, k)) {
            return -1;
        }
        return result;
    }

    public boolean isFull(int[] nums, int k) {
        for (int num : nums) {
            if (num < k) {
                return false;
            }
        }
        return true;
    }
}
