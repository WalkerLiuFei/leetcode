package personal.walker.a.notes;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinNum {

    public static void main(String[] args) {
        System.out.println(minNumber(new int[]{322,3223}));;
        System.out.println(minNumber(new int[]{322,3221}));;

        System.out.println(minNumber(new int[]{342,3423}));
        System.out.println(minNumber(new int[]{342,3523}));
        System.out.println(minNumber(new int[]{344,3444}));
        System.out.println(minNumber(new int[]{3,30}));
        System.out.println(minNumber(new int[]{3,30,34,5,9}));
        System.out.println(minNumber(new int[]{5,34}));
    }
    // 322,3221 => 3221322,3223221
    // 342,3422 => 3423422,3423342
    // 3224,3223 => 32243223, 32233224
    static public String minNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()){
                    return o1.compareTo(o2);
                }
                if (o1.charAt(0) == o2.charAt(0)){
                    int i = 0;
                    while (i < o1.length() && i < o2.length() && o1.charAt(i) == o2.charAt(i)){
                        i++;
                    }
                    if (i < o1.length() && i < o2.length() && o1.charAt(i) != o2.charAt(i)){
                        return o1.charAt(i) - o2.charAt(i);
                    }
                    i = 0;
                    while (i < o1.length() && i < o2.length() && o1.charAt(i) == o2.charAt(i) && o1.charAt(i) == o1.charAt(0)){
                        i++;
                    }
                    String theLonger = o1.length() < o2.length() ? o2 : o1;
                    if (theLonger.charAt(i) > theLonger.charAt(0)){
                        return  o1.length() > o2.length() ? 1 : -1;
                    }
                    if (theLonger.charAt(i) < theLonger.charAt(0)){
                        return o1.length() > o2.length() ? -1 :1 ;
                    }
                    return 0;
                }
                return o1.charAt(0) - o2.charAt(0);
            }
        });
        for (int num : nums){
            queue.add(String.valueOf(num));
        }
        StringBuilder resultBuilder = new StringBuilder();
        while(!queue.isEmpty()){
            resultBuilder.append(queue.poll());
        }
        return resultBuilder.toString();
    }


    class Solution {
        public String minNumber(int[] nums) {
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++)
                strs[i] = String.valueOf(nums[i]);
            Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
            StringBuilder res = new StringBuilder();
            for(String s : strs)
                res.append(s);
            return res.toString();
        }
    }
}
