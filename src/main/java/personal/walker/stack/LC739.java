package personal.walker.stack;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.Stack;

public class LC739 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        String resultStr = gson.toJson(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        System.out.println(resultStr);
    }

    class Temperature {
        int index;
        int temperature;

        Temperature(int index, int temperature) {
            this.index = index;
            this.temperature = temperature;
        }
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Temperature> stack = new Stack<>();
        for (int index = 0; index < temperatures.length; index++) {
            while (!stack.isEmpty()) {
                if (stack.peek().temperature < temperatures[index]) {
                    Temperature temperature = stack.pop();
                    result[temperature.index] = index - temperature.index;
                }else {
                    break;
                }
            }
            stack.push(new Temperature(index, temperatures[index]));

        }
        return result;
    }

}
