package personal.walker.dfs;

import personal.walker.Solution;

import java.util.ArrayList;

//  https://leetcode.com/problems/course-schedule/submissions/
public class LC207 implements Solution {
    // 现在这道题用DFS会超时
    @Override
    public void runTestCases() {
        System.out.println(canFinish(5,new int[][]{{0,1}}));
        System.out.println(canFinish(2,new int[][]{{0,1},{1,0}}));
        System.out.println(canFinish(5,new int[][]{{1,2},{2,0},{3,4}}));
        System.out.println(canFinish(3,new int[][]{{0,2},{1,2},{2,0}}));
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
        System.out.println(canFinish(3,new int[][]{{1,0},{1,2},{0,1}}));
        System.out.println(canFinish(3,new int[][]{{1,0},{1,2},{0,1}}));
    }

    private  ArrayList<Integer>[] depen;

    /**
     *  使用拓扑排序的思想来做这道题，拓扑相当于普通dfs来讲就是多了个状态
     *  拓扑排序在遍历过节点后可以将节点从
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 下标 index i 依赖的课程 list，然后里面找环就行了，没有值的说明是可以直接上的
        depen = new ArrayList[numCourses];
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
        int[] visitStatus = new int[numCourses];
        for (int i = 0 ; i < numCourses;i ++){
            //没有依赖，肯定就没有环，没有环就满足--num
            if (depen[i] == null){
                continue;
            }
            if (topologicalSortWithDFS(i, visitStatus)){
                return false;
            }
        }
        return true;
    }
    //  利用拓扑排序建仓是否存在环
    public  boolean topologicalSortWithDFS(int i, int[] visitStatus){
        // 形成了环，此链路不满足要求return false
        // 正在遍历那么肯定是就
        if (visitStatus[i] == 1 ){
            return true;
        }
        if (visitStatus[i] == 2 ){
            return false;
        }
        // 没有依赖，这个链路是满足要求，dfs结束
        if (depen[i] == null){
            visitStatus[i] = 2;
            return false;
        }
        // 将其标识为visiting
        visitStatus[i] = 1;
        for (Integer iDepend : depen[i]){
            // 只要依赖的课程有一个无法满足就需要跳出
            if (topologicalSortWithDFS(iDepend, visitStatus)){
                return true;
            }
        }
        // 出栈一定要记得标识为false
        visitStatus[i] = 2;
        return false;
    }
    /**
     1. 构建一张图，上过 course a 之后可以上的所有coureses after courses
     1. 使用map（x -> x course should be token before）构建 构建一个有向图，图中
     2. 从任一在途中搜索并且在这个图在达到上过course满足要求前中没有找到环，那么就可以return true.
     3. 注意： 我们只需要找到环就可以知道从开始上课的这个节课就是不对的

     **/
    public boolean canFinish_tle(int numCourses, int[][] prerequisites) {

        // 下标 index i 依赖的课程 list，然后里面找环就行了，没有值的说明是可以直接上的
        depen = new ArrayList[numCourses];
        for (int[] x : prerequisites){
            if (depen[x[0]] == null){
                depen[x[0]] = new ArrayList<>();
            }
            depen[x[0]].add(x[1]);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0 ; i < numCourses;i ++){
            //没有依赖，肯定就没有环，没有环就满足--num
            if (depen[i] == null){
                continue;
            }
            if (dfs(i, visited)){
                return false;
            }
        }
        return true;
    }
    // 检查课程i的依赖是否形成环，如果形成了环，客说明这个课程是没办法上的
    public  boolean dfs(int i, boolean[] visited){
        // 形成了环，此链路不满足要求return false
        if (visited[i]){
            return true;
        }
        visited[i] = true;
        // 没有依赖，这个链路是满足要求，dfs结束
        if (depen[i] == null){
            return false;
        }
        for (Integer iDepend : depen[i]){
            // 只要依赖的课程有一个无法满足就需要跳出
            if (dfs(iDepend, visited)){
                return true;
            }
        }
        // 出栈一定要记得标识为false
        visited[i] = false;
        return false;
    }
}
