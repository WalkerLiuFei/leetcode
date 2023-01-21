package personal.walker.array;

import personal.walker.Solution;

import java.util.Arrays;

public class LC1011 implements Solution {
    @Override
    public void runTestCases() {
//        System.out.println(shipWithinDays(new int[]{3,2,2,4,1,4},3));
//        System.out.println(shipWithinDays(new int[]{1,2,3,4,5,6,7,8,9},5));
//        System.out.println(shipWithinDays(new int[]{33,23,4,2,4,5,12,2,4,51,23,51,41,5,9},5));
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
        //System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10));

    }

    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0];
        for (int v : weights) {
            if (v > left) {
                left = v;
            }
        }
        int right = Arrays.stream(weights).sum();
        int mid = 0;

        while (left < right) {
            mid = (right - left) / 2 + left;
            int needDays = needDays(weights, mid);
            // 体积太大
            if (needDays <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        while (needDays(weights,right) > days){
            right += 1;
        }
        return right;
    }

    int needDays(int[] weights, int capacity) {
        int days = 0;
        int left = capacity;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] > capacity){
                return Integer.MAX_VALUE;
            }
            if (left < weights[i]) {
                left = capacity;
                days++;
            }
            left -= weights[i];
        }
        return days + (left == capacity ? 0 : 1);
    }
}
