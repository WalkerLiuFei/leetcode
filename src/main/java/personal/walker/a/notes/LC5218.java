package personal.walker.a.notes;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LC5218 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minimumNumbers(58, 9));
        System.out.println(minimumNumbers(36, 3));
        System.out.println(minimumNumbers(44, 4));
        System.out.println(minimumNumbers(1, 1));
        System.out.println(minimumNumbers(5, 1));
        System.out.println(minimumNumbers(4, 0));
        System.out.println(minimumNumbers(10, 0));
        System.out.println(minimumNumbers(3000, 0));
        System.out.println(minimumNumbers(3000, 1));
    }

    /**
     * if num == 0 {
     * result ++
     * }
     * k, 1k,2k,3k.......
     * 11k, 21k,31k.....
     * num -
     */

    class Node {
        int level;
        int num;

        public Node(int _level,
                    int _num) {
            this.level = _level;
            this.num = _num;
        }
    }

    public int minimumNumbers(int num, int k) {
        if (num == 0) {
            return 0;
        }
        Set<Integer> allNumSet = new HashSet<>();

        allNumSet.add(k);
        recursiveGenerate(num, k, 10, allNumSet);

        allNumSet.remove(0);
        List<Integer> numList = new ArrayList<>(allNumSet);


        // 使用BFS找到最短路径
        Queue<Node> queue = new LinkedList<>();
        for (int i = numList.size() - 1; i >= 0; i--) {
            if (num - numList.get(i) ==0){
                return 1;
            }
            queue.add(new Node( 1, num - numList.get(i)));
        }

        int levelNum = queue.size();
        while (!queue.isEmpty()) {
            int newLevelNum =0;
            while (levelNum > 0) {
                Node node = queue.poll();
                levelNum--;
                for (int i = numList.size() - 1; i >= 0; i--) {
                    if (node.num - numList.get(i) > 0){
                        queue.add(new Node(node.level + 1, node.num - numList.get(i)));
                        newLevelNum++;
                    }else if (node.num - numList.get(i) == 0) {
                        return node.level + 1;
                    }
                }
            }
            levelNum =  newLevelNum ;
        }

        //recursive(num, numList.size() - 1, numList, 0);
        return -1;
    }

    // 注意109 这种
    private void recursiveGenerate(int num, int k, int bitPosition, Set<Integer> allNum) {
        if (bitPosition > num) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            int candidate = i * bitPosition + k;
            if (candidate > num) {
                break;
            }
            allNum.add(candidate);
            recursiveGenerate(num, candidate, bitPosition * 10, allNum);
        }
    }

}
