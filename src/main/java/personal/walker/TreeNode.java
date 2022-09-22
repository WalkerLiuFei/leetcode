package personal.walker;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeNode {
    static final int COUNT = 10;

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode convertArrayToListNode(Integer[] elements,int index){
        if ( elements == null  || index > elements.length - 1 || elements[index] == null){
            return null;
        }
        TreeNode treeNode = new TreeNode(elements[index]);
        treeNode.left = convertArrayToListNode(elements,2 * index + 1 );
        treeNode.right = convertArrayToListNode(elements,2 * index + 2 );
        return treeNode;
    }

    // Function to print binary tree in 2D
// It does reverse inorder traversal
    public static void print2DUtil(TreeNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.right, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print(" ");
        System.out.print(root.val + "\n");

        // Process left child
        print2DUtil(root.left, space);
    }

    // Wrapper over print2DUtil()
    static void print2D(TreeNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
}
