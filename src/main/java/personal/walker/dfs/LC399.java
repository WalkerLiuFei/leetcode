package personal.walker.dfs;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC399 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(Arrays.toString(calcEquation(Util.convertTwoDimensionToStringList("[[\"a\",\"b\"],[\"b\",\"c\"]]"),new double[]{2.0,3.0},Util.convertTwoDimensionToStringList("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]"))));
    }

    class Dividend {
        String target;
        Double result;

        Dividend(String _target,Double _result){
            this.target = _target;
            this.result = _result;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String,List<Dividend>> mapper = new HashMap<>();
        for (int i = 0; i < equations.size(); i ++){
            List<String> equation = equations.get(i);
            mapper.putIfAbsent(equation.get(0),new ArrayList<>());
            mapper.get(equation.get(0)).add(new Dividend(equation.get(1),values[i]));

            mapper.putIfAbsent(equation.get(1),new ArrayList<>());
            mapper.get(equation.get(1)).add(new Dividend(equation.get(0), 1 / values[i]));
        }
        for (int i = 0; i < queries.size(); i++){
            result[i] =  dfs(mapper,queries.get(i).get(0),queries.get(i).get(1), new HashSet<>(),1);
        }
        return result;
    }
    double dfs(Map<String,List<Dividend>> mapper, String dividend, String target, Set<String> visited, double result){
        if (!mapper.containsKey(dividend)){
            return -1;
        }
        if (dividend.equals(target)){
            return result;
        }
        if (visited.contains(dividend)){
            return -1;
        }
        visited.add(dividend);
        for (Dividend dividend1  : mapper.get(dividend)){
            double temp =  dfs(mapper,dividend1.target,target,visited,result  * dividend1.result);
            if (temp != -1){
                return temp;
            }
            //visited.remove(dividend1.target);
        }
        return -1;
    }
}

