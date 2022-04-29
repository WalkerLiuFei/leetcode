package personal.walker.top.like;

public class LC42 {

    public void runTestCases(){
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap2(new int[]{4,2,0,3,2,5}));
    }
    /**
     * 某个小格子可以攒的水等于 它两边比高的较小那个"柱子"减去自身高度，就是可以积攒的水的数量，那么就需要往右找一个最高点，往左找一个最高的点，即可
     * 可以适当剪枝。 所谓剪枝就是找到左侧最大和右侧最大，中间的可以都用这个两个值
     * corn case:
     * 1. height的长度必须 > 2 不然攒不住水,所以遍历从1开始即可，不然没有意义
     */

//    Runtime: 195 ms O(n^2)
//    Memory Usage: 43.1 MB
    public int trap(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int result = 0;
        int index = 1;
        while ( index < height.length - 1) {
            // 找出左侧最大
            int maxLeft = 0;
            int maxRight = 0;
            int maxRightIndex = index + 1;
            for (int i = index - 1; i >= 0; i--) {
                if (height[i] > maxLeft) {
                    maxLeft = height[i];
                }
            }
            for (int i = index + 1; i < height.length; i++) {
                if (height[i] > maxRight) {
                    maxRight = height[i];
                    maxRightIndex = i;
                }
            }
            int trapWaterIndex = Math.min(maxLeft, maxRight) - height[index];
            if (trapWaterIndex > 0) {
                result += trapWaterIndex;
            }
            if (height[index] > maxLeft) {
                maxLeft = height[index];
            }
            index++;
            while (index < maxRightIndex) {
                trapWaterIndex = Math.min(maxLeft, maxRight) - height[index];
                if (trapWaterIndex > 0) {
                    result +=trapWaterIndex;
                }
                if (height[index] > maxLeft) {
                    maxLeft = height[index];
                }
                index++;
            }
        }
        return result;
    }

    /**
     * 利用双指针进行优化，通过上面的解法可知道，如果可以预先获知左侧最高高度的 height 和右侧最高高度的height就可以省略掉循环了，就像内部的for循环一样
     * 典型的 prefix DP 算法
     */
    public int trap2(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int result = 0;
        int[] leftMaxHeight = new int[height.length];
        leftMaxHeight[0] = 0;
        int[] rightMaxHeight = new int[height.length];
        rightMaxHeight[height.length-1] = 0;
        for (int i = 1 ;i < height.length;i++){
            leftMaxHeight[i] = Math.max(leftMaxHeight[i-1],height[i-1]);
        }
        for (int i = height.length - 2 ;i >=0;i--){
            rightMaxHeight[i] = Math.max(rightMaxHeight[i+1],height[i + 1]);
        }
        for (int i = 0;i < height.length;i++){
            result += Math.max(Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i], 0);
        }
        return result;
    }
}
