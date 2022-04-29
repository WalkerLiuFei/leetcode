package personal.walker.sliding.window;

import personal.walker.Solution;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
public class LC76 implements Solution {
    @Override
    public void runTestCases() {
//       System.out.println(minWindow("ADOBECODEBANC","ABC"));
//        System.out.println(minWindow("ACBANC","ABC"));
//        System.out.println(minWindow("a","a"));
//        System.out.println(minWindow("abc","bc"));
        System.out.println(minWindow("abc", "bc"));
//
//      System.out.println(minWindow("ABC","ABCCSDA"));
//        System.out.println(minWindow("ABCDE","FGHR"));
//       System.out.println(minWindow("ABCCSDA","ACD"));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        // 字符串t中字符出现的次数
        byte[] sBytes = s.getBytes();
        int[] tByteMap = new int[128];

        for (byte c : t.getBytes()) {
            tByteMap[c]++;
        }


        String result = "";
        //

        /**
         *  根据题设要求，我们结果的长度必须 >= t.length,所以初始化j为 t.length
         * 1. 移动j知道满足 s[i:j] 包含了t，
         * 2. 然后再再移动i之后s[i:j]不满足包含了t，首先有了第一个结果s[i-1:j]
         * 3. 重复1.
         */

        int i = 0, j = 0;

        for (; j < sBytes.length; j++) {
            // 移动j
            boolean flag = false;
            for (; j < sBytes.length; j++) {
                //move
                tByteMap[sBytes[j]]--;
                // s[i..j] 是否满足要求，满足要求即tByteMap中所有的值都小于零
                for (int count : tByteMap) {
                    flag = count <= 0;
                    if (!flag) {
                        break;
                    }
                }
                // 找到了一个满足要求的，跳出循环
                if (flag) {
                    break;
                }
            }
            // 没有满足要求的，且j已经移动到s最后，那么跳出
            if (!flag) {
                break;
            } else if (t.length() == 1) {
                return t;
            } else if (result.equals("")) {
                result = s.substring(0, j + 1);
            }
            // 移动i
            while (i < j) {
                //move i 知道不满足需求
                byte b = sBytes[i];
                tByteMap[b]++;
                i++;
                if (tByteMap[b] > 0) {
                    break;
                }
            }
            // s满足不了t跳出循环
//            if (i >= j){
//                continue;
//            }
            //
            if (result.equals("") || j - i + 1 < result.length()) {
                result = s.substring(i - 1, j + 1);
            }
        }
        return result;
    }


    /**
     * 1. 如果A 和B可以互换，B和C可以互换，那么A,C就可以互换，同理，A和B不可以互换，A和B不可以互换，但是B和C可以互换，那么A和C一定不可以互换
     * 可以联想到素数筛方法，用一个和rectangles同长度的bool 数组来标识是否已经被筛选过。
     * 累加算数 ： n + n-1 + .... + 0 = (n + 1) * n / 2
     **/
    public long interchangeableRectangles(int[][] rectangles) {
        // 下标为初始化长度
        int[] exchangable = new int[rectangles.length];

        if (rectangles.length < 2) {
            return 0;
        }
        long result = 0;
        Map<BigDecimal, Integer> ratioMap = new HashMap<BigDecimal, Integer>();

        for (int i = 0; i < rectangles.length - 1; i++) {
            BigDecimal ratio = BigDecimal.valueOf ((rectangles[i][1])).divide(BigDecimal.valueOf(rectangles[i][0]));
            Integer count = ratioMap.get(ratio);
            if (count == null) {
                ratioMap.put(ratio, 1);
            } else {
                ratioMap.put(ratio, count++);
            }
        }
        for (BigDecimal key : ratioMap.keySet()) {
            Integer count = ratioMap.get(key);
            result += (long) (count + 1) * count / 2;
        }
        return result;
    }
}
