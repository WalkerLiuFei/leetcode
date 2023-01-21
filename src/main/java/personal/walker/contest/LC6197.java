package personal.walker.contest;

import personal.walker.Solution;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC6197 implements Solution {
    @Override
    public void runTestCases() {
        LUPrefix luPrefix = new LUPrefix(6);
        luPrefix.upload(5);
        System.out.println(luPrefix.longest());;
        luPrefix.upload(4);
        System.out.println(luPrefix.longest());;
        luPrefix.upload(3);
        System.out.println(luPrefix.longest());;

        luPrefix.upload(2);
        System.out.println(luPrefix.longest());;

        luPrefix.upload(1);
        System.out.println(luPrefix.longest());;

        luPrefix.upload(6);
        System.out.println(luPrefix.longest());;




//
//
//        LUPrefix  luPrefix = new LUPrefix(3);
//        luPrefix.upload(3);
//        System.out.println(luPrefix.longest());;
//        luPrefix.upload(1);
//        System.out.println(luPrefix.longest());;
//        luPrefix.upload(2);
//        System.out.println(luPrefix.longest());;


    }

    class LUPrefix {
        boolean[] prefixes;
        int longest = 0;


        PriorityQueue<Integer> minQP = new PriorityQueue<>();
         public LUPrefix(int n) {
            prefixes = new boolean[n + 1];
        }

        public void upload(int video) {
            if (video >= prefixes.length) {
                return;
            }
            prefixes[video] = true;

            minQP.add(video);
         }

        public int longest() {
            if (minQP.size() > 0 && minQP.peek() == longest + 1) {
                while (minQP.size() > 0 && minQP.peek() == longest + 1){
                    longest = minQP.poll();
                }
                return longest;
            }

            return longest;
        }
    }
}
