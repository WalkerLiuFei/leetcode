package personal.walker.array;

import personal.walker.Solution;

public class LC6327 implements Solution {
    @Override
    public void runTestCases() {

    }


    public int minNumber(int[] nums1, int[] nums2) {
        int[] a = new int[10];
        int[] b = new int[10];
        for (int n: nums1) {
            a[n]++;
        }
        for (int n: nums2) {
            b[n]++;
        }
        for (int i = 1 ; i < 10; i ++){
            if (b[i] != 0 && a[i] != 0){
                return i;
            }
        }
        int bit1 =  0 ;
        for (int i = 1 ; i < 10; i ++){
            if (a[i] != 0 ){
                bit1 = i;
                break;
            }
        }
        int bit2 =  0 ;
        for (int i = 1 ; i < 10; i ++){
            if (b[i] != 0 ){
                bit2 = i;
                break;
            }
        }
        return   bit1 < bit2 ?  bit1 * 10 + bit2 :  bit2 * 10 + bit1;
    }

}
