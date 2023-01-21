package personal.walker.contest;

import personal.walker.Main;
import personal.walker.Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LC6212 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(equalFrequency("abcc"));
        System.out.println(equalFrequency("bac"));
        System.out.println(equalFrequency("aazz"));
        System.out.println(equalFrequency("adbc"));
        System.out.println(equalFrequency("cbccca"));
        System.out.println(equalFrequency("cabcd"));
        System.out.println(equalFrequency("ccccaa"));
        System.out.println(equalFrequency("ddaccb"));
        System.out.println(equalFrequency("abbcc"));
        System.out.println(equalFrequency("aa"));
    }

    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> mapper = new HashMap<>();
        for (char c : word.toCharArray()) {
            mapper.putIfAbsent(c, 0);
            mapper.put(c, mapper.get(c) + 1);
        }
        if (mapper.size() == 1){
            return true;
        }
        if (word.length() == mapper.size()) {
            return true;
        }
        HashMap<Integer,Integer> lengthMapper = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : mapper.entrySet()) {
            lengthMapper.putIfAbsent(entry.getValue(),0);
            lengthMapper.put(entry.getValue(),lengthMapper.get(entry.getValue()) + 1);
            if (lengthMapper.size()  > 2){
                return false;
            }
        }
        Integer pre = null;
        Integer preValue = null;
        for (Map.Entry<Integer,Integer> entry : lengthMapper.entrySet()){
            if (pre == null){
                pre = entry.getKey();
                preValue = entry.getValue();
                continue;
            }
            if (Math.abs(entry.getKey() - pre) > 1){
                return false;
            }
            if (preValue == 1 || entry.getValue() == 1){
                return true;
            }
        }
        return false;
    }

}
