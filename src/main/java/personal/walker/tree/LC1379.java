package personal.walker.tree;

import personal.walker.Solution;
import personal.walker.TreeNode;

public class LC1379 implements Solution {
    @Override
    public void runTestCases() {

    }

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (cloned == null){
            return null;
        }
        if (cloned.val == target.val){
            return target;
        }
        return null;
    }

}
