package personal.walker.contest;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC6274 implements Solution {
    @Override
    public void runTestCases() {
        topStudents(new String[]{"fkeofjpc","qq","iio"},new String[]{"jdh","khj","eget","rjstbhe","yzyoatfyx","wlinrrgcm"},
                new String[]{"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio","gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx","tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe","jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh","yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq","fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v","wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq","d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"},
                new int[]{96537918,589204657,765963609,613766496,43871615,189209587,239084671,908938263},3);
    }


    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveMap = new HashSet<>(Arrays.asList(positive_feedback));
        Set<String> negativeMap = new HashSet<>(Arrays.asList(negative_feedback));
        Map<Integer, Integer> soccerMap = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] words = report[i].split(" ");
            int positiveCount = 0;
            int negativeCount = 0;
            for (String word : words) {
                if (positiveMap.contains(word)) {
                    positiveCount++;
                }
                if (negativeMap.contains(word)) {
                    negativeCount++;
                }
            }
            soccerMap.putIfAbsent(student_id[i], 0);
            soccerMap.put(student_id[i], soccerMap.get(student_id[i]) + positiveCount * 3 - negativeCount);
        }
        List<int[]> resultPairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : soccerMap.entrySet()) {
            resultPairs.add(new int[]{entry.getKey(), entry.getValue()});
        }
        resultPairs.sort((o1, o2) -> {
            if (o1[1] != o2[1]) {
                return o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        List<Integer> result = new ArrayList<>();
        for (int[] pair : resultPairs) {
            result.add(pair[0]);
            if (result.size() == k){
                break;
            }
        }
         return result;
    }
}
