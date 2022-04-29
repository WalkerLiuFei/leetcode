package personal.walker.dfs;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.awt.geom.QuadCurve2D;
import java.util.*;
import java.util.stream.Collectors;

public class LC210 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(findOrder(5,new int[][]{{1,0}})));
        System.out.println(gson.toJson(findOrder(2,new int[][]{{0,1},{1,0}})));
        System.out.println(gson.toJson(findOrder(5,new int[][]{{1,2},{2,0},{3,4}})));
        System.out.println(gson.toJson(findOrder(3,new int[][]{{0,2},{1,2},{2,0}})));
        System.out.println(gson.toJson(findOrder(5,new int[][]{{1,4},{2,4},{3,1},{3,2}})));
        System.out.println(gson.toJson(findOrder(3,new int[][]{{1,0},{1,2},{0,1}})));
        System.out.println(gson.toJson(findOrder(3,new int[][]{{1,0},{1,2},{0,1}})));
    }



    /**
     * 207的延展，先标记需要上的
     **/
    public  int[] findOrder(int numCourses, int[][] prerequisites) {

        // 下标 index i 依赖的课程 list，然后里面找环就行了，没有值的说明是可以直接上的
        ArrayList<Integer>[] depen = new ArrayList[numCourses];
        for (int[] x : prerequisites){
            if (depen[x[0]] == null){
                depen[x[0]] = new ArrayList<>();
            }
            depen[x[0]].add(x[1]);
        }
        /**
         * 1 : 正在遍历
         * 2 : 已经遍历过了 （在拓扑排序中的意思就是已经从图里面移除掉了）
         *
         */

        /**
         * -2 : initial
         * -1 : visiting
         * other : visited and is the result index
         */
        int[] visitedStatus = new int[numCourses];

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0 ; i < numCourses;i ++){
            //没有依赖，肯定就没有环，没有环就满足--num
            if (topologicalSortWithDFS(depen,i, visitedStatus,queue)){
                return new int[0];
            }
        }
        int[] result = new int[numCourses];

        for (int resultIndex = 0;!queue.isEmpty();resultIndex++){
            result[resultIndex] = queue.poll();
        }
        return result;
    }
    //  利用拓扑排序建仓是否存在环
    public  boolean topologicalSortWithDFS(ArrayList<Integer>[] depen, int i, int[] visitStatus,Queue<Integer> partialResultOrder){
        // 形成了环，此链路不满足要求return false
        // 正在遍历那么肯定是就
        if (visitStatus[i] == 1){
            return true;
        }
        // visited
        if (visitStatus[i] == 2){
            return false;
        }
        // 没有依赖，这个链路是满足要求，dfs结束
        if (depen[i] == null){
            visitStatus[i] = 2;
            partialResultOrder.add(i);
            return false;
        }
        // 将其标识为visiting
        visitStatus[i] = 1;
        for (Integer iDepend : depen[i]){
            // 只要依赖的课程有一个无法满足就需要跳出
            if (topologicalSortWithDFS(depen,iDepend, visitStatus,partialResultOrder)){
                return true;
            }
        }
        // 出栈一定要记得标识为false
        visitStatus[i] = 2;
        // 将其压入栈中
        partialResultOrder.add(i);
        return false;
    }
}
