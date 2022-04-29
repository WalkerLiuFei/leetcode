package personal.walker.top.like;

public class LC11 {
    /**
     * 简单的 two double pointer algorithm
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int frontPointer = 0;
        int endPointer = height.length - 1;
        int max = (endPointer - frontPointer) * Math.min(height[endPointer], height[frontPointer]);
        while (endPointer > frontPointer) {
            int backEnd = height[endPointer];
            int frontEnd = height[frontPointer];
            int temp = Math.min(frontEnd, backEnd) * (endPointer - frontPointer);
            if (frontEnd < backEnd) {
                frontPointer++;
            } else
                endPointer--;
            if (max < temp)
                max = temp;
        }
        return max;
    }
}
