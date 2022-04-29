package personal.walker.top.like;


import java.util.ArrayList;
import java.util.List;

public class LC179 {
    public void runTestCases(){
//        System.out.println(largestNumber(new int[]{111311, 1113}));
        System.out.println(largestNumber(new int[]{3,30,34,5,9}));
        System.out.println(largestNumber(new int[]{34323,3432}));
        System.out.println(largestNumber(new int[]{0,0,0,0}));
    }

    /**
     *
     *
     * 这里的想法基本上是实现一个字符串比较器来决定在连接期间应该首先出现哪个字符串。
     * 因为当您有 2 个数字时（让我们将它们转换为字符串），您将只遇到 2 种情况：
     * String s1 = "9";
     * String s2 = "31";
     *
     * String case1 =  s1 + s2; // 931
     * String case2 = s2 + s1; // 319
     * 显然，就值而言，case1 大于 case2。 因此，我们应该将 s1 放在 s2 之前。
     * 特殊case ： 如果是0开头的，直接响应字符串 0
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> numStrs = new ArrayList<String>();
        for (int num : nums){
           numStrs.add(String.valueOf(num));
        }
        numStrs.sort((o1, o2) -> {
            String result1 = o1 + o2;
            String result2 = o2 + o1;
            return result2.compareTo(result1);
        });

        String result =  String.join("",numStrs);
        if (result.charAt(0) == '0'){
            return "0";
        }
        return result;
    }
}
