package personal.walker.contest;

import personal.walker.Solution;

public class LC5219 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * @param candies
     * @param k
     * @return
     */
    public int maximumCandies(int[] candies, long k) {
        // (nlgn)
        int left = 0,right = 10_000_000;
        while (left < right) {
            int mid = (left + left + 1) / 2;
            int count = 0;
            for (int candy : candies) {
                count += candy / mid;
            }
            if (count < k) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    /**
     *  思考将每片 candie 最小可以分成的份数, 最小的份数首先取决于最小的candie
     *  1. 如果吗，那最小的candie 可以满足需求则直接return，说明满足需求，如果满足不了 candie递减 然后拆每个candie看是否满足需求
     *  时间复杂度O(NM),TLE
     *  2.
     * @param candies
     * @param k
     * @return
     */
    // brute force
    public int maximumCandies_TLE(int[] candies, long k) {
        int  max = candies[0];
        for (int candie : candies){
            if (candie < max){
                max = candie;
            }
        }
        for (int j = max; j >= 0;j--){
            int count = 0;
            for (int i = 0; i < candies.length;i++){
                count += candies[i] / max;
                if (count >= k){
                    return j;
                }
            }
        }
       return 0;
    }
}
