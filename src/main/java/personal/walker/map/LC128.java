package personal.walker.map;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LC128 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(longestConsecutive(new int[]{0,100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        System.out.println(longestConsecutive(new int[]{0,3,7,0,0,0}));
    }


    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){return 0;}

        UnionFind unionFind = new UnionFind(nums);
        unionFind.doUnion();
        int max = unionFind.findMaxPart();
        Gson gson = new Gson();
        System.out.println(gson.toJson(unionFind.numParentMap));

        return max;
    }

    class UnionFind{
        Map<Integer,Integer> numParentMap;
        UnionFind(int[] nums){
            numParentMap = new HashMap<>();
            for (int num : nums){
                numParentMap.put(num,num);
            }
        }
        public int  findMaxPart(){
            Map<Integer,Integer> sizeMap = new HashMap<>();
            int max = 1;
            for (Integer num : numParentMap.keySet()){
                int root = findRoot(num);
                int size = sizeMap.getOrDefault(root,0) + 1;
                sizeMap.put(root,size);
                if (size > max){
                    max = size;
                }
            }
            return max;
        }
        public void doUnion(){
            for (Integer num : numParentMap.keySet()){
                if (numParentMap.containsKey(num+1)){
                    union(num,num+1);
                }
                if (numParentMap.containsKey(num-1)){
                    union(num,num-1);
                }
                if (numParentMap.containsKey(num-1) && numParentMap.containsKey(num+1)){
                    union(num-1,num+1);
                }
            }
        }
        public void union(Integer a,Integer b){
            Integer aRoot = findRoot(a);
            Integer bRoot = findRoot(b);
            numParentMap.put(aRoot,bRoot);
        }
        public Integer findRoot(Integer num){
             while (!numParentMap.get(num).equals(num)){
                 Integer parent = numParentMap.get(num);
                 numParentMap.put(num,numParentMap.get(parent));
                 num = numParentMap.get(parent);
            }

            return num;
        }
    }

}
