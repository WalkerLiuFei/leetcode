package personal.walker.contest;

import personal.walker.Solution;

public class LC6348 implements Solution {
    @Override
    public void runTestCases() {

    }

    public long pickGifts(int[] gifts, int k) {
        while (k > 0) {
            int maxI = 0;
            for (int i = 0; i < gifts.length;i++){
                if (gifts[i] > gifts[maxI]){
                    maxI = i;
                }
            }
            gifts[maxI] = (int) Math.sqrt(gifts[maxI]);
            k--;
        }
        long result = 0l;
        for (int gift : gifts){
            result += gift;
        }
        return result;
    }
}
