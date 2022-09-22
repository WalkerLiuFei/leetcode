package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LC6121 implements Solution {
    @Override
    public void runTestCases() {
        //[1,5,11,10,7,0,0,1,13,13,5,12]
       System.out.println(Arrays.toString(smallestTrimmedNumbers(new String[]{"64333639502","65953866768","17845691654","87148775908","58954177897","70439926174","48059986638","47548857440","18418180516","06364956881","01866627626","36824890579","14672385151","71207752868"},
               Util.convertTwoDimensionToIntegerArray("[[9,4],[6,1],[3,8],[12,9],[11,4],[4,9],[2,7],[10,3],[13,1],[13,1],[6,1],[5,10]]"))));
    }

    class Query {
        int trim;
        int k;

        int  index;
        Query(int trim,int k,int index ){
            this.trim = trim;
            this.k = k;
            this.index = index;
        }
    }
    class Result {
        String num;
        int index;
        Result(String num,
        int index){
            this.num = num;
            this.index = index;
        }
    }
    public int[] smallestTrimmedNumbers(String[] numStringArray, int[][] queryArray) {
        Query[] queries = new Query[queryArray.length];
        for (int i = 0; i < queryArray.length;i ++ ){
            queries[i] = new Query(queryArray[i][1],queryArray[i][0],i);
        }
        Arrays.sort(queries, Comparator.comparingInt(o -> o.trim));


        int[] result = new int[queryArray.length];

        for (Query query : queries){
            PriorityQueue<Result> priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o2.num.compareTo(o1.num) == 0){
                    return o2.index - o1.index ;
                }
                return o2.num.compareTo(o1.num);
            });
            for (int i = 0; i < numStringArray.length;i++){
                priorityQueue.add(new Result(numStringArray[i].substring(numStringArray[i].length()-query.trim), i));
                if (priorityQueue.size() > query.k){
                    priorityQueue.remove();
                }
            }
            result[query.index] = priorityQueue.poll().index;
        }
        return result;
    }

}
