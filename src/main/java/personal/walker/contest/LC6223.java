package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.TreeNode;
import personal.walker.Util;

import java.util.*;

public class LC6223 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(treeQueries(TreeNode.convertArrayToListNode(new Integer[]{5,8,9,2,1,3,7,4,6},0),new int[]{3,2,4,8})));
    }

    class LevelNodes {
        TreeNode node;
        LevelNodes parent;

        public LevelNodes(TreeNode node, LevelNodes parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        Queue<LevelNodes> queue = new LinkedList<>();
        queue.add(new LevelNodes(root,null));
        int levelCount = 1;
        List<LevelNodes> levelNodes = new ArrayList<>();
        int level = 0;
        while (!queue.isEmpty()){

            List<LevelNodes> newLevelNodes = new ArrayList<>();

            int newLevelCount = 0;
            level++;
            while (levelCount > 0){
                LevelNodes node = queue.poll();
                if (node.node.right != null){
                    newLevelCount++;
                    newLevelNodes.add(new LevelNodes(node.node.right,node));
                    queue.add(new LevelNodes(node.node.right,node));
                }
                if (node.node.left != null){
                    newLevelCount++;
                    newLevelNodes.add(new LevelNodes(node.node.left,node));
                    queue.add(new LevelNodes(node.node.left,node));
                }
                levelCount--;
            }
            levelCount = newLevelCount;
            if (newLevelNodes.size() > 0){
                levelNodes = newLevelNodes;
            }
        }

        List<Set<Integer>> levelMap = new ArrayList<>();
        while (level > 0){
            Set<Integer> set = new HashSet<>();
            HashMap<Integer,LevelNodes> upperLevelNodes = new HashMap<>();
            for (LevelNodes node : levelNodes){
                set.add(node.node.val);
                if (node.parent != null){
                    upperLevelNodes.put(node.parent.node.val,node.parent);
                }
            }
            levelMap.add(set);
            levelNodes = new ArrayList<>(upperLevelNodes.values());
            level--;
        }
        Collections.reverse(levelMap);
        int[] result = new int[queries.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < queries.length;i++){
            List<Set<Integer>> tempLevelMap = new ArrayList<>(levelMap);
            for (Set<Integer> kv : tempLevelMap){
                kv.remove(queries[i]);
            }
            for (int j = 0; j < tempLevelMap.size(); j++){
                if (tempLevelMap.get(j).isEmpty()){
                    result[i] = j - 1;
                    break;
                }
            }
            if (result[i] == -1){
                result[i] = tempLevelMap.size() - 1;
            }
        }
        return result;
    }

}
