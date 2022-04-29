package personal.walker.top.like;

import personal.walker.Solution;

public class LC1306 implements Solution {


    @Override
    public void runTestCases() {
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2},5));
        System.out.println(canReach(new int[]{4,2,3,0,3,1,2},0));
        System.out.println(canReach(new int[]{3,0,2,1,2},2));
        System.out.println(canReach(new int[]{3,0},0));
        System.out.println(canReach(new int[]{1,0},0));
        System.out.println(canReach(new int[]{0},0));
        System.out.println(canReach(new int[]{1,1,1,1,1,1,1,1,0},3));
        System.out.println(canReach(new int[]{1,1,1,1,1,1,1,1,0},3));


        System.out.println(canReach2(new int[]{4,2,3,0,3,1,2},5));
        System.out.println(canReach2(new int[]{4,2,3,0,3,1,2},0));
        System.out.println(canReach2(new int[]{3,0,2,1,2},2));
        System.out.println(canReach2(new int[]{3,0},0));
        System.out.println(canReach2(new int[]{1,0},0));
        System.out.println(canReach2(new int[]{0},0));
        System.out.println(canReach2(new int[]{1,1,1,1,1,1,1,1,0},3));
        System.out.println(canReach2(new int[]{1,1,1,1,1,1,1,1,0},3));

    }

    /**
     *  dfs 算法，需要一个辅助数组记录是否遍历过的index。
     * @param arr
     * @param start
     * @return
     */


    public boolean canReach2(int[] arr, int start) {
        if (start < 0 ||start > arr.length - 1 || arr[start] < 0){
            return false;
        }
        if (arr[start] == 0){
            return true;
        }
        arr[start] = -arr[start];
        return canReach2(arr,start - arr[start]) ||  canReach2(arr,start + arr[start]);
    }

    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return helper(arr,start - arr[start],start,visited) ||  helper(arr,start + arr[start],start,visited);
    }
    public boolean helper(int[] arr, int start, int targetIndex,boolean[] visited){
        if (start < 0 ||start > arr.length - 1 || visited[start] ){
            return false;
        }
        if (arr[start] == 0){
            return true;
        }
//        if (start == targetIndex){
//            return false;
//        }
        visited[start] = true;
        return helper(arr,start - arr[start],targetIndex,visited) || helper(arr,start + arr[start],targetIndex,visited);
    }
}
