package personal.walker.array;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC6430 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(circularGameLosers(5,2)));
    }


    public int[] circularGameLosers(int n, int k) {
        boolean[] all = new boolean[n];

        int current = 1;
        int idx = 0;
        while (true) {
            if (all[idx]) {
                break;
            }
            all[idx] = true;
            idx = (current * k + idx) % (n);
            current++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < all.length; i++) {
            if (!all[i]) {
                result.add(i + 1);
            }
        }
        // Add elements to the list...

        int[] array = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }


}
