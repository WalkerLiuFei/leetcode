package personal.walker.contest;

import personal.walker.ListNode;
import personal.walker.Solution;

import java.util.Arrays;

public class LC6111 implements Solution {
    @Override
    public void runTestCases() {
        //spiralMatrix(5,3)
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int[] element : result){
            Arrays.fill(element,-1);
        }
        int rowStart = 0; // 变更这个
        int rowEnd = m - 1;

        int columnStart = 0;
        int columnEnd = n - 1;
        while (head != null && rowStart <  rowEnd && columnStart < columnEnd){
            int columnIndex = columnStart;
            int rowIndex = rowStart;
//            if (columnStart == rowEnd && columnStart == columnEnd){
//                result[columnIndex][columnIndex] = head.val;
//                head = head.next;
//            }
            // 填充column,tia
            for (; columnIndex < columnEnd && head != null; columnIndex++) {
                result[rowIndex][columnIndex] = head.val;
                head = head.next;
            }

            for (;rowIndex <  rowEnd && head != null; rowIndex++) {
                result[rowIndex][columnIndex] = head.val;
                head = head.next;
            }

            for (; columnIndex >  columnStart && head != null; columnIndex--) {
                result[rowIndex][columnIndex] = head.val;
                head = head.next;
            }

            for (;rowIndex >  rowStart && head != null; rowIndex--) {
                result[rowIndex][columnIndex] = head.val;
                head = head.next;
            }
            rowStart ++;
            rowEnd--;
            columnStart++;
            columnEnd--;
            // 填充row
        }

        if (rowStart == rowEnd){
            for (;columnStart <=columnEnd && head != null;columnStart++){
                result[rowStart][columnStart] = head.val;
                head = head.next;
            }
            return result;
        }
        if (columnStart == columnEnd){
            for (;rowStart <=rowEnd && head != null;rowStart++){
                result[rowStart][columnStart] = head.val;
                head = head.next;
            }
            return result;
        }
        return result;
    }
}
