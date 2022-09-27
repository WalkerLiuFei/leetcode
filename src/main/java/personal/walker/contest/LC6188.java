package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;
import java.util.Comparator;

public class LC6188 implements Solution {
    @Override
    public void runTestCases() {

    }
    class People {
        String name ;
        int height;

        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        People[] peoples = new People[names.length];
        String[] result = new String[names.length];
        for (int i = 0; i < names.length;i++){
            peoples[i]  = new People(names[i],heights[i]);
        }
        Arrays.sort(peoples, (o1, o2) -> o2.height - o1.height);
        for (int i = 0; i < peoples.length;i ++){
            result[i] = peoples[i].name;
        }
        return result;
    }

}
