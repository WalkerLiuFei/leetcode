package personal.walker.design;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC981 implements Solution {
    @Override
    public void runTestCases() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("a","b",1);
        timeMap.set("a","b1",3);

        timeMap.set("a","b2",5);
        timeMap.set("a","b3",7);
        timeMap.set("a","b4",100);

        System.out.println(timeMap.get("a",0));
        System.out.println(timeMap.get("a",2));
        System.out.println(timeMap.get("a",8));
        System.out.println(timeMap.get("a",99));
        System.out.println(timeMap.get("a",130));
        System.out.println(timeMap.get("b",130));

    }
    class TimeMap {
        Map<String,TreeMap<Integer,String>> storage = new HashMap<>();
        public TimeMap() {
            storage = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            storage.putIfAbsent(key,new TreeMap<>());
            storage.get(key).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> timeStampValue = storage.get(key);
            if (timeStampValue == null){
                return null;
            }
            Map.Entry<Integer,String> entry = timeStampValue.floorEntry(timestamp);
            return entry == null ? null:entry.getValue();
        }
    }
}
