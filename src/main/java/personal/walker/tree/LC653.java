package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LC653 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        midOrder(list,root);
        boolean flag = false;
        for (int i =0, j = list.size() - 1; j > i && !flag; ){
            if (list.get(i) + list.get(j) > k){
                j--;
            }else if (list.get(i) + list.get(j) < k)  {
                i++;
            }else {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public void midOrder(List<Integer> list, TreeNode node){
        if (node == null){
            return;
        }
        midOrder(list,node.left);
        list.add(node.val);
        midOrder(list,node.right);
    }

}
