package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6267 implements Solution {
    @Override
    public void runTestCases() {
     //  System.out.println(isPossible(11, Util.convertTwoDimensionToIntegerList("[[5,9],[8,1],[2,3],[7,10],[3,6],[6,7],[7,8],[5,1],[5,7],[10,11],[3,7],[6,11],[8,11],[3,4],[8,9],[9,1],[2,10],[9,11],[5,11],[2,5],[8,10],[2,7],[4,1],[3,10],[6,1],[4,9],[4,6],[4,5],[2,4],[2,11],[5,8],[6,9],[4,10],[3,11],[4,7],[3,5],[7,1],[2,9],[6,10],[10,1],[5,6],[3,9],[2,6],[7,9],[4,11],[4,8],[6,8],[3,8],[9,10],[5,10],[2,8],[7,11]]")));
      //  System.out.println(isPossible(5, Util.convertTwoDimensionToIntegerList("[[1,2],[2,3],[3,4],[4,2],[1,4],[2,5]]")));
//
        //System.out.println(isPossible(4, Util.convertTwoDimensionToIntegerList("[[1,2],[3,4]]")));
        //System.out.println(isPossible(21, Util.convertTwoDimensionToIntegerList("[[2,19],[16,17],[8,14],[2,16],[12,20],[12,14],[16,18],[15,16],[10,21],[3,5],[13,18],[17,20],[14,17],[9,12],[5,15],[5,6],[3,7],[2,21],[10,13],[8,16],[7,18],[4,6],[9,1],[13,21],[18,20],[7,14],[4,19],[5,8],[3,11],[11,1],[7,12],[4,7],[3,16],[13,17],[17,19],[9,13],[7,19],[10,16],[4,13],[4,5],[2,15],[12,19],[11,16],[2,9],[11,17],[17,1],[16,21],[4,10],[10,14],[14,16],[4,1],[13,20],[5,20],[4,14],[4,21],[10,20],[2,14],[8,15],[4,8],[6,19],[15,1],[19,1],[8,19],[15,21],[3,12],[11,18],[9,17],[18,19],[7,21],[3,21],[16,19],[11,15],[5,1],[8,17],[3,15],[8,1],[10,19],[3,8],[6,16],[2,8],[5,18],[11,13],[11,20],[14,21],[6,20],[4,20],[12,13],[5,12],[10,11],[9,15],[3,19],[9,20],[14,18],[21,1],[13,19],[8,21],[2,13],[3,10],[9,18],[19,21],[6,7],[3,18],[2,18],[6,14],[3,17],[5,21],[14,20],[8,9],[16,1],[3,4],[13,1],[5,9],[4,15],[17,21],[20,21],[2,17],[13,14],[11,14],[9,16],[10,18],[6,15],[6,12],[3,13],[5,11],[6,1],[12,17],[8,10],[5,10],[8,18],[4,12],[10,1],[6,13],[4,18],[7,20],[7,16],[2,6],[12,21],[4,17],[15,18],[13,16],[15,20],[7,10],[6,10],[2,20],[7,15],[18,1],[12,1],[3,20],[7,1],[14,15],[4,9],[11,19],[7,9],[5,17],[18,21],[6,21],[8,11],[6,17],[3,14],[7,11],[5,7],[7,13],[6,8],[6,9],[10,12],[5,16],[2,4],[17,18],[9,11],[12,16],[3,6],[12,18],[3,9],[11,12],[14,19],[10,15],[5,13],[8,13],[15,17],[2,10],[11,21],[20,1],[6,18],[2,12],[19,20],[6,11],[8,12],[2,3],[12,15],[2,11],[9,10],[7,17],[9,19],[13,15],[7,8],[4,11],[2,5],[5,19],[16,20],[15,19],[9,14],[14,1],[10,17],[9,21],[2,7],[8,20],[5,14],[4,16]]")));
        System.out.println(isPossible(5,Util.convertTwoDimensionToIntegerList("[[4,3],[4,5],[5,3],[3,1],[5,2]]")));
    }


    public boolean isPossible(int n, List<List<Integer>> edges) {
        HashMap<Integer, Set<Integer>> graph = new HashMap<>();
        for (List<Integer> list : edges) {
            graph.putIfAbsent(list.get(0), new HashSet<>());
            graph.putIfAbsent(list.get(1), new HashSet<>());
            graph.get(list.get(0)).add(list.get(1));
            graph.get(list.get(1)).add(list.get(0));
        }
        Set<Integer> odds = new HashSet<>();
        for (Map.Entry<Integer, Set<Integer>> setEntry : graph.entrySet()) {
            if (setEntry.getValue().size() % 2 == 1) {
                odds.add(setEntry.getKey());
            }
        }
        if (odds.size() > 4) {
            return false;
        }


        // case 1 ： 互相链接
        for (Integer point : odds) {
            if (graph.get(point).size() % 2 == 0) {
                continue;
            }
            for (Integer point2 : odds) {
                if (point2.equals(point) || graph.get(point).contains(point2) || graph.get(point2).size() % 2 == 0) {
                    continue;
                }
                graph.get(point).add(point2);
                graph.get(point2).add(point);
                break;
            }
        }
        // check
        boolean flag = true;
        for (Integer p : odds){
            flag = graph.get(p).size() % 2 == 0;
            if (!flag){
                break;
            }
        }
        if (flag){
            return true;
        }
        if (odds.size() != 2){
            return false;
        }

        // case 2 , 用一个辅助点链接
        List<Integer> lefts = new ArrayList<>(odds);

        for (Map.Entry<Integer,Set<Integer>> setEntry : graph.entrySet()){
           if (!setEntry.getValue().contains(lefts.get(0)) && !setEntry.getValue().contains(lefts.get(1))){
               return true;
           }
        }
        return false;
    }

}
