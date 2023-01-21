package personal.walker.sliding.window;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC904 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(totalFruit(new int[]{1,2,1}));
        System.out.println(totalFruit(new int[]{0,1,2,2}));
        System.out.println(totalFruit(new int[]{1,2,3,2,2}));
        System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
        System.out.println(totalFruit(new int[]{1,0,1,4,1,4,1,2,3}));
        System.out.println(totalFruit(new int[]{1,1,6,5,6,6,1,1,1,1}));
    }

    int result = 0;

    public int totalFruit(int[] fruits) {
        int nextIndex = 0;
        while (true){
            nextIndex = helper(fruits,nextIndex);
            if (nextIndex >= fruits.length){
                break;
            }
        }
        return result;
    }

    public int helper(int[] fruits, int index) {
        if (index >= fruits.length ){
            return index+1;
        }
        int count = 0;
        int nextStartIndex;
        int basket1Type = fruits[index];
        while (index < fruits.length && fruits[index] == basket1Type) {
            index++;
            count++;
        }
        if (index == fruits.length) {
            result = Math.max(count, result);
            return index;
        }
        nextStartIndex = index;

        int basket2Type = fruits[index];
        while (index < fruits.length && (fruits[index] == basket2Type || fruits[index] == basket1Type)) {
            count++;
            index++;
        }
        result = Math.max(count, result);
        return nextStartIndex;
    }

}
