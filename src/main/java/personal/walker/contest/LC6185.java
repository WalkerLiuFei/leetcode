package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6185 implements Solution {
    @Override
    public void runTestCases() {

    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int result = 0;
        for (int i = 0, j = 0; i < players.length && j < trainers.length;){
            while (j < trainers.length && trainers[j] < players[i]){
                j++;
            }
            if (j < trainers.length){
                result++;
            }
            // j have been taken,.
            j++;
            i++;
        }
        return result;
    }
}
