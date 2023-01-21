package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC6221 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(mostPopularCreator(new String[]{"a","a","a","a"},new String[]{"a","a","a","a"},new int[]{100000,100000,100000,100000}));;
    }

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String,Long> popularMap = new HashMap<>();
        Long maxPopularView = 0L;
        for (int i = 0; i < views.length; i++){
            popularMap.putIfAbsent(creators[i],0L);
            popularMap.put(creators[i],popularMap.get(creators[i]) + views[i]);
            if (maxPopularView < popularMap.get(creators[i])){
                maxPopularView = popularMap.get(creators[i]);
            }
        }
        Map<String,Integer> resMap = new HashMap<>();

        for (int i = 0; i < creators.length;i ++){
            if (popularMap.get(creators[i]) < maxPopularView){
                continue;
            }
           if (resMap.get(creators[i]) != null){
                if (views[resMap.get(creators[i])] > views[i]){
                    continue;
                }else if (views[resMap.get(creators[i])] == views[i] && ids[resMap.get(creators[i])].compareTo(ids[i]) <= 0){
                    continue;
                }
           }
           resMap.put(creators[i],i);
        }
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : resMap.entrySet()){
            result.add(Arrays.asList(entry.getKey(),ids[entry.getValue()]));
        }
        return result;
    }

}
