package personal.walker.a.notes;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

/**
 * https://www.youtube.com/watch?v=qosJ4632QAg
 *
 * https://zxi.mytechroad.com/blog/graph/leetcode-1202-smallest-string-with-swaps/
 */
public class LC1202 implements Solution {
    @Override
    public void runTestCases() {
      System.out.println(smallestStringWithSwaps("vbjjxgdfnru",
              Util.convertTwoDimensionToIntegerList("[[8,6],[3,4],[5,2],[5,5],[3,5],[7,10],[6,0],[10,0],[7,1],[4,8],[6,2]]")));
    }

    /**
     * 0. a[1],a[2] = a[2],a[1] 和 a[2],a[1] = a[1],a[2] 含义一致
     * 1. 首先将pairs 中的pair替换为 pair[0] < pair[1]，然后根据pairs中的pair根据升序排序
     * 2.
     * @param s
     * @param pairs
     * @return
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

        Set<String> allStringOccur = new HashSet<>();
        dfs(s,pairs,allStringOccur);
        List<String> allStringList = new ArrayList<>(allStringOccur);
        Collections.sort(allStringList);
        return allStringList.get(0);
    }

    public void dfs(String s, List<List<Integer>> pairs, Set<String> allStringOccur){
        if (allStringOccur.contains(s)){
            return;
        }
        System.out.println(s);
        allStringOccur.add(s);
        for (List<Integer> pair : pairs){
            byte[] sBytes = s.getBytes();
            byte tmp = sBytes[pair.get(0)];
            sBytes[pair.get(0)] = sBytes[pair.get(1)];
            sBytes[pair.get(1)] = tmp;
            dfs(new String(sBytes),pairs, allStringOccur);
        }
    }



}
