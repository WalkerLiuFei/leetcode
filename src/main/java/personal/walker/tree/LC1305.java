package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC1305 implements Solution {
    @Override
    public void runTestCases() {

    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        inOrder(root1,list1);
        inOrder(root2,list2);
        int i=0,j=0;
        while (i < list1.size() || j < list2.size()){
            if (i >= list1.size()){
                result.addAll(list2.subList(j,list2.size()));
                break;
            }
            if (j >= list1.size()){
                result.addAll(list1.subList(i,list1.size()));
                break;
            }
            while (i < list1.size() && list1.get(i) <= list1.get(j)){
                result.add(list1.get(i));
                i++;
            }
            while (j < list2.size() && list1.get(j) <= list1.get(i)){
                result.add(list1.get(j));
                j++;
            }
        }
        return result;
    }

    public void inOrder(TreeNode node,List<Integer> result){
        if (node == null){
            return;
        }
        inOrder(node.left,result);
        result.add(node.val);
        inOrder(node.right,result);
    }
}
