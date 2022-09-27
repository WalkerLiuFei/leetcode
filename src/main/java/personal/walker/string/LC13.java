package personal.walker.string;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;

public class LC13 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(romanToInt("LVIII"));
    }

    public int romanToInt(String s) {

        Map<Character,Integer> mapper = new HashMap<>();
        mapper.put('I',1);
        mapper.put('V',5);
        mapper.put('X',10);
        mapper.put('L',50);
        mapper.put('C',100);
        mapper.put('D',500);
        mapper.put('M',1000);
        int result = mapper.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if (mapper.get(s.charAt(i)) > mapper.get(s.charAt(i-1))){
                result -= 2 * mapper.get(s.charAt(i-1));
            }
            result += mapper.get(s.charAt(i));
        }
        return result;
    }

}
