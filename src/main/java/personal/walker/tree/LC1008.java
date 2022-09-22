package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.Stack;

public class LC1008 implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * 遍历数组，按照性质，先root，后left,然后
     * 使用一个单调辅助栈，往栈中压数据，如果遍历到的元素小于栈顶，则进栈，是栈顶的左child,
     * 如果大于栈顶需要将其pop直到栈顶的元素大于当前这个元素，且此元素为上一个被pop元素的右child,并将其压入栈顶
     * @param nums
     * @return
     */

    public TreeNode bstFromPreorder(int[] nums) {
        // 使用一个单调辅助栈即可，如果遍历到的
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(nums[0]);
        stack.push(root);
        for (int i = 1; i < nums.length;i++){
            TreeNode newNode = new TreeNode(nums[i]);
            TreeNode lastPopNode = null;
            while (stack.size() > 0 && stack.peek().val < nums[i]){
                lastPopNode = stack.pop();
            }
            if (lastPopNode != null){
                lastPopNode.right = newNode;
            }else{
                stack.peek().left = newNode;
            }
            stack.push(newNode);
        }
        return root;
    }

}
