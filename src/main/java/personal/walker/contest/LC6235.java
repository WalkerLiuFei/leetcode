package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.TreeNode;
import personal.walker.a.notes.LC5218;

import java.util.*;

public class LC6235 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int minimumOperations(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = queue.size();
        while (!queue.isEmpty()) {
            int newLevelNum =0;
            int[] nums = new int[levelNum];
            int i = 0;
            while (levelNum > 0) {
                TreeNode node = queue.poll();
                nums[i++] = node.val;
                levelNum--;
                if (node.left != null){
                    queue.add(node.left);
                    newLevelNum++;
                }
                if (node.right != null){
                    queue.add(node.right);
                    newLevelNum++;
                }
            }
            result += minSwaps(nums,nums.length);
            levelNum =  newLevelNum ;
        }
        return result;
    }


        // Return the minimum number
        // of swaps required to sort the array
        public int minSwaps(int[] arr, int N)
        {

            int ans = 0;
            int[] temp = Arrays.copyOfRange(arr, 0, N);

            // Hashmap which stores the
            // indexes of the input array
            HashMap<Integer, Integer> h
                    = new HashMap<Integer, Integer>();

            Arrays.sort(temp);
            for (int i = 0; i < N; i++)
            {
                h.put(arr[i], i);
            }
            for (int i = 0; i < N; i++)
            {

                // This is checking whether
                // the current element is
                // at the right place or not
                if (arr[i] != temp[i])
                {
                    ans++;
                    int init = arr[i];

                    // If not, swap this element
                    // with the index of the
                    // element which should come here
                    swap(arr, i, h.get(temp[i]));

                    // Update the indexes in
                    // the hashmap accordingly
                    h.put(init, h.get(temp[i]));
                    h.put(temp[i], i);
                }
            }
            return ans;
        }
        public void swap(int[] arr, int i, int j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

}
