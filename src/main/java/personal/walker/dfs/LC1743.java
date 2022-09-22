package personal.walker.dfs;

import personal.walker.Solution;

import java.util.*;

public class LC1743 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int[] restoreArray(int[][] adjacentPairs) {

        Map<Integer,List<Integer>> connections = new HashMap();
        for (int i = 0; i < adjacentPairs.length; i++) {
            connections.put(adjacentPairs[i][0],new ArrayList<>());
            connections.put(adjacentPairs[i][1],new ArrayList<>());
        }
        for (int[] pair : adjacentPairs) {
            connections.get(pair[0]).add(pair[1]);
            connections.get(pair[1]).add(pair[0]);
        }
        Integer start = null;
       for (Map.Entry<Integer,List<Integer>> entry : connections.entrySet()){
           if (entry.getValue().size() == 1){
               start = entry.getKey();
           }
       }

        Map<Integer,Boolean> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        dfs(result, connections, visited, start);
        int[] array = new int[adjacentPairs.length + 1];
        for (int i = 0 ; i  < adjacentPairs.length+ 1; i++){
            array[i] = result.get(i);
        }
        return array;
    }


    public void dfs(List<Integer> result,Map<Integer,List<Integer>> connections,  Map<Integer,Boolean> visited, Integer n) {
        if (visited.get(n) != null && visited.get(n)){
            return;
        }
        visited.put(n,true);
        result.add(n);
        for (int i : connections.get(n)){
            dfs(result,connections,visited,i);
        }
    }
}
