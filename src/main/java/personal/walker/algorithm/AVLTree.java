package personal.walker.algorithm;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AVLTree {
    public void insert (){
        /**
         * 1. 插入新节点：首先，将新节点插入到AVL树中，与在二叉搜索树中插入节点的过程类似。如果新节点的键值大于当前节点，则向右子树继续搜索；如果新节点的键值小于当前节点，则向左子树继续搜索。
         *    一直搜索到空节点，然后将新节点插入到空节点的位置。
         * 2. 更新高度：在插入新节点后，从新节点开始向上更新每个节点的高度。AVL树中每个节点的高度等于它的左右子树中最大的高度加1。如果新节点的高度比当前节点的高度更高，则更新当前节点的高度。
         * 3. 检查平衡因子：在更新高度后，检查当前节点的平衡因子。平衡因子等于左子树的高度减去右子树的高度。如果平衡因子的绝对值大于1，则表示当前节点的子树失去了平衡。
         * 4. 重新平衡：如果当前节点的平衡因子绝对值大于1，则需要通过旋转操作重新平衡子树。假设当前节点为A，左子树高度大于右子树高度，则分为以下两种情况：
         *   1.  左-左情况(LL)：A的左子节点的左子树高度大于等于右子树高度。解决方法是将A向右旋转一次，使得A的左子节点成为新的根节点。旋转前后，A的左子节点成为A的父节点，A成为A的左子节点的右子节点。
         *   2.  左-右情况(LR)：A的左子节点的右子树高度大于左子树高度。解决方法是先将A的左子节点向左旋转一次，再将A向右旋转一次。旋转前后，A的左子节点的右子节点成为A的新的左子节点，A的左子节点成为A的新的右子节点。
         * 5. 重复以上步骤：如果在重新平衡子树后，当前节点的父节点失衡，则需要继续进行旋转操作，直到AVL树重新平衡为止。
         *
         *
         * 第四步的伪代码：
         * // 左旋转操作
         * function rotateLeft(node):
         *     rightNode = node.right # 右子节点
         *     rightLeftNode = rightNode.left # 右子节点的左子节点
         *
         *     # 旋转操作
         *     rightNode.left = node # 将右子节点的左子节点指向当前节点
         *     node.right = rightLeftNode # 将当前节点的右子节点指向右子节点的左子节点
         *
         *     # 更新高度
         *     node.height = max(height(node.left), height(node.right)) + 1
         *     rightNode.height = max(height(rightNode.left), height(rightNode.right)) + 1
         *
         *     # 返回旋转后的新的根节点
         *     return rightNode
         *
         * // 右旋操作
         * function rotateRight(node):
         *     leftNode = node.left # 左子节点
         *     leftRightNode = leftNode.right # 左子节点的右子节点
         *
         *     # 旋转操作
         *     leftNode.right = node # 将左子节点的右子节点指向当前节点
         *     node.left = leftRightNode # 将当前节点的左子节点指向左子节点的右子节点
         *
         *     # 更新高度
         *     node.height = max(height(node.left), height(node.right)) + 1
         *     leftNode.height = max(height(leftNode.left), height(leftNode.right)) + 1
         *
         *     # 返回旋转后的新的根节点
         *     return leftNode
         *
         */
    }

    /**
     * fn rotation(A):
     *   B := A.left
     *   A.left = B.right
     *
     *   if B.right != null:
     *      B.right.parent = A
     *   B.right = A
     *   A.parent = B
     *   B.parent = P // P is parent of A
     *   if P != null:
     *      if P.left = A:
     *          P.left = B
     *      else:
     *          P.right = B
     *   return B
     * @param root
     * @return
     */
    

    List<Integer> orderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        result.addAll(orderTraversal(node.left));
        result.add(node.val);
        result.addAll(orderTraversal(node.right));
        return result;
    }
}
