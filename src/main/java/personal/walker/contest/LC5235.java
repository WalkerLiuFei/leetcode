package personal.walker.contest;

import personal.walker.Solution;

import java.util.*;

public class LC5235 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9},{888,233}})); ;
    }

    /**
     *  拓扑排序问题，answer 1 好解决只需要找到从节点 x 出发 找到没有环的节点即可，answer 2是在将answer 1中的node去除以后寻找没有环的节点即可
     *  如果 1一个人被击败了只有一次，那么这个人肯定是被answer 1 中的人击败的，在拓扑排序结果中找到answer1 后面的人即可
     * @param matches
     * @return
     */
    public List<List<Integer>> findWinners(int[][] matches) {
         List<Integer> allWinner = new ArrayList<>();
        List<Integer> loseOne = new ArrayList<>();
        // TODO : make this as lambda.
        Map<Integer,List<Integer>> winner2Losers = new HashMap<>();
        for (int[] match : matches){
            winner2Losers.putIfAbsent(match[0],new ArrayList<>());
            winner2Losers.get(match[0]).add(match[1]);
        }
        // 被谁击败了
        Map<Integer,List<Integer>> loser2Winner = new HashMap<>();
        for (int[] match : matches){
            loser2Winner.putIfAbsent(match[1],new ArrayList<>());
            loser2Winner.get(match[1]).add(match[0]);
        }
        for (Integer winner : winner2Losers.keySet()){
            if (!loser2Winner.containsKey(winner)){
                allWinner.add(winner);
            }else if (loser2Winner.get(winner).size() == 1){
                loseOne.add(winner);
            }
        }
        for (Integer loser : loser2Winner.keySet()){
            if (loser2Winner.get(loser).size() == 1 && !winner2Losers.containsKey(loser)){
                loseOne.add(loser);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        Collections.sort(allWinner);
        Collections.sort(loseOne);
        result.add(allWinner);
        result.add(loseOne);
        return result;
    }

}
