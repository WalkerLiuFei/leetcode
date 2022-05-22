package personal.walker.union.find;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC399 implements Solution {
    @Override
    public void runTestCases() {

    }

    class Dividend {
        List<Double> values ;

        List<String> divisors ;
        public void addDivisors(String divisor,double value){
            divisors.add(divisor);
            values.add(value);
        }
        Dividend(){
            values = new ArrayList<>();
            divisors = new ArrayList<>();
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Dividend> allDividend = new HashMap<>();
        for (int index = 0; index < equations.size();index++){
            List<String> equation = equations.get(index);
            double value = values[index];
            Dividend dividend = allDividend.getOrDefault(equation.get(0),new Dividend());
            dividend.addDivisors(equation.get(1),value);
            allDividend.put(equation.get(0),dividend);

            dividend = allDividend.getOrDefault(equation.get(1),new Dividend());
            dividend.addDivisors(equation.get(0), 1.0 / value);
            allDividend.put(equation.get(1), dividend);
        }
        return null;
    }
}
