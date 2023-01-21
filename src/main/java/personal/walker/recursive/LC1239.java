package personal.walker.recursive;

import personal.walker.Solution;

import java.util.*;

public class LC1239 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int maxLength(List<String> arr) {
        List<String> newArr = new ArrayList<>();
        for (String v : arr) {
            boolean flag = false;
            boolean[] set = new boolean[26];
            for (Character c : v.toCharArray()) {
                flag = set[c - 'a'];
                if (flag) {
                    break;
                }
                set[c - 'a'] = true;
            }
            if (!flag){
                newArr.add(v);
            }
        }
        return tracking(newArr, new boolean[26],0);
    }


    int tracking(List<String> arr, boolean[] currentSet, int index) {
        if (index >= arr.size()) {
            return sizeOfArray(currentSet);
        }
        int result = sizeOfArray(currentSet);
        for (int i = index; i < arr.size(); i++) {
            boolean flag = false;
            boolean[] set = Arrays.copyOf(currentSet,26);
            for (Character c : arr.get(i).toCharArray()) {
                flag = set[c - 'a'];
                if (flag) {
                    break;
                }
            }
            if (!flag) {
                for (char c : arr.get(i).toCharArray()){
                    set[c - 'a'] = true;
                }
                result = Math.max(tracking(arr,set,i + 1),result);
            }
        }
        return result;
    }

     int sizeOfArray(boolean[] array){
        int result = 0;
        for (boolean b : array){
            if (b) {result++;}
        }
        return result;
    }
}
