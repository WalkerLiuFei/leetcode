package personal.walker.array;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2007 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(Arrays.toString(findOriginalArray(new int[]{1,3,4,2,6,8})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{0,0,0,0,0,0,0,0})));
        System.out.println(Arrays.toString(findOriginalArray(new int[]{6,3,0,1})));

    }

    public int[] findOriginalArray(int[] changed) {
        if ((changed.length & 0x01) == 1){
            return new int[]{};
        }
        int max = 0;
        for (int n : changed){
            if (n > max){
                max = n;
            }
        }
        List<Integer> result = new ArrayList<>();
        int[] counter = new int[max + 1];
        for (int num : changed){
            counter[num]++;
        }
        for (int i = 0; i < max / 2 + 1;i++){
            if (counter[i] > 0 && counter[i + i] > 0){
                while (counter[i] > 0){
                    counter[i + i]--;
                    counter[i]--;
                    result.add(i);
                }
                if (counter[i + i] < 0 || counter[i] < 0){
                    return new  int[]{};
                }
            }
        }
        if (result.size() != changed.length / 2){
            return new int[]{};
        }
        return result.stream().mapToInt(i->i).toArray();
    }
}
