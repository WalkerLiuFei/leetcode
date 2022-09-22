package personal.walker.contest;

import personal.walker.Solution;

public class LC6152 implements Solution {
    @Override
    public void runTestCases() {
        minNumberOfHours(5,3,new int[]{1,4,3,2},new int[]{2,6,3,1});
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int result = 0;
        for (int i = 0 ; i < energy.length;i++){
            if (initialEnergy <= energy[i]){
                int temp = energy[i] + 1;
                result += temp  - initialEnergy;
                initialEnergy = temp;
            }
            initialEnergy = initialEnergy - energy[i];

            if (initialExperience <= experience[i]){
                int temp = experience[i] + 1;
                result += temp  - initialExperience;
                initialExperience = temp;
            }
            initialExperience = initialExperience + experience[i];
            System.out.println(result);
        }
        return  result;
    }

}
