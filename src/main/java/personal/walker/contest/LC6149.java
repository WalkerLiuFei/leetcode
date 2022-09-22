package personal.walker.contest;

import com.google.gson.Gson;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import personal.walker.Solution;

import java.util.HashMap;

public class LC6149 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(edgeScore(new int[]{1,3,1,2}));;
    }
    public int edgeScore(int[] edges) {

        //HashMap<Integer,Integer> scoreMap = new HashMap<>();
        long[] scoreMap = new long[edges.length];
        for (int i = 0; i < edges.length;i++){
            scoreMap[edges[i]] =  scoreMap[edges[i]] + i;
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(scoreMap));
        long result = scoreMap[0];
        int index = 0;
        for (int i = 0; i < scoreMap.length;i++){
            if (scoreMap[i] > result){
                index = i;
                result  =  scoreMap[i];
            }
        }
        return index;
    }
}
