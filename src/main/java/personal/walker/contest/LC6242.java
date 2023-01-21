package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6242 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(closestNodes(TreeNode.convertArrayToListNode(new Integer[]{6, 2, 13, 1, 4, 9, 15, null, null, null, null, null, null, 14}, 0), Arrays.asList(2, 5, 16)).toString());
        ;
    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int min = queries.get(0);
        int max = queries.get(0);
        for (Integer i : queries) {
            if (i < min) {
                min = i;
            }
            if (i > max) {
                max = i;
            }
        }
        System.out.printf("min > %d max > %d\n", min, max);
        List<Integer> integerList = new ArrayList<>();
        toArray(root, integerList);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            result.add(binarySearch(integerList, queries.get(i), 0, integerList.size() - 1));
        }
        return result;
    }

    public List<Integer> binarySearch(List<Integer> integerList, int target, int i, int j) {

        while (i < j) {
            int mid = (i + j) / 2;
            if (integerList.get(mid) > target) {
                j = mid - 1;
            } else if (integerList.get(mid) < target) {
                i = mid + 1;
            } else {
                return Arrays.asList(integerList.get(mid), integerList.get(mid));
            }
        }
        if (i == 0 && integerList.get(i) > target) {
            return Arrays.asList(-1, integerList.get(i));
        }
        if (i == integerList.size() - 1 && integerList.get(i) < target) {
            return Arrays.asList(integerList.get(j), -1);
        }
        if (integerList.get(i) > target) {
            int k = i - 1;
            while (k >= 0 && integerList.get(k) > target) {
                k--;
            }
            if (k < 0) {
                return Arrays.asList(-1,integerList.get(i));
            }else {
                return   Arrays.asList(integerList.get(k),integerList.get(i));
            }
        }
        if (integerList.get(i) < target) {
            int k = i + 1;
            while (k < integerList.size() && integerList.get(k) < target) {
                k++;
            }
            if (k == integerList.size()) {
                return  Arrays.asList(integerList.get(i),-1);
            }else {
                return   Arrays.asList(integerList.get(i),integerList.get(k));
            }
        }
        return Arrays.asList(integerList.get(i), integerList.get(j));
    }

    public void toArray(TreeNode node, List<Integer> integerList) {
        if (node == null) {
            return;
        }
        toArray(node.left, integerList);
        integerList.add(node.val);
        toArray(node.right, integerList);
    }
}
