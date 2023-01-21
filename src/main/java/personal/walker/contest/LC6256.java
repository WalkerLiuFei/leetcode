package personal.walker.contest;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC6256 implements Solution {
    @Override
    public void runTestCases() {

    }



    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges){
            map.putIfAbsent(edge[0],new ArrayList<>());
            map.putIfAbsent(edge[1],new ArrayList<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        return 0;
    }

    /**
     * 记录距离起点的距离， 遍历每个路径距离的点
     * @param map
     * @param distanceMap
     * @param visited
     * @return
     */
    public boolean hasCycle( Map<Integer, List<Integer>> map,Map<Integer,Integer> distanceMap,boolean[] visited){
            return false;
    }
}
