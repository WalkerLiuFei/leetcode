package personal.walker.contest;

import personal.walker.Solution;

public class LC6162 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(garbageCollection(new String[]{"G", "M", "P"}, new int[]{1, 3}));
    }

    // 1 + 2 + 4
    class HouseGarbage {
        int metal = 0;
        int paper = 0;
        int glass = 0;
        int travelTime = 0;

        HouseGarbage(int _metal, int _paper, int _glass, int _traveTime) {
            this.metal = _metal;
            this.paper = _paper;
            this.glass = _glass;
            this.travelTime = _traveTime;
        }

    }

    public int garbageCollection(String[] garbage, int[] travel) {
        HouseGarbage[] houseGarbage = new HouseGarbage[garbage.length];
        int useGlassTruckIndex = 0;
        int usePaperTruckIndex = 0;
        int useMetalTruckIndex = 0;

        for (int i = 0; i < garbage.length; i++) {
            houseGarbage[i] = new HouseGarbage(0, 0, 0, 0);
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'G') {
                    houseGarbage[i].glass++;
                    useGlassTruckIndex = i;
                }
                if (garbage[i].charAt(j) == 'P') {
                    houseGarbage[i].paper++;
                    usePaperTruckIndex = i;
                }
                if (garbage[i].charAt(j) == 'M') {
                    houseGarbage[i].metal++;
                    useMetalTruckIndex = i;
                }
            }
            if (i > 0) {
                houseGarbage[i].travelTime = travel[i - 1];
            }
        }
        int result = 0;
        for (int i = 0; i < houseGarbage.length; i++) {
            HouseGarbage value = houseGarbage[i];
            if (useGlassTruckIndex < i){
                break;
            }

            result += value.glass;
            result += value.travelTime;
        }

        for (int i = 0; i < houseGarbage.length; i++) {
            HouseGarbage value = houseGarbage[i];
            if (useMetalTruckIndex < i){
                break;
            }
            result += value.metal;
            result += value.travelTime;
        }

        for (int i = 0; i < houseGarbage.length; i++) {
            HouseGarbage value = houseGarbage[i];
            if (usePaperTruckIndex < i){
                break;
            }
            result += value.paper;
            result += value.travelTime;
        }

        return result;
    }
}
