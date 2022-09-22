package personal.walker.contest;

import personal.walker.Solution;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC6130 implements Solution {
    @Override
    public void runTestCases() {
        NumberContainers container = new NumberContainers();
        container.find(10);
        container.change(1,10);
        container.change(2,10);
        System.out.println(container.find(10));
        container.change(1,20);
        System.out.println(container.find(10));
    }

    class NumberContainers {
        Map<Integer,Integer> index2Number;
        Map<Integer, PriorityQueue<Integer>> number2Indexes;
        public NumberContainers() {
            index2Number = new HashMap<>();
            number2Indexes = new HashMap<>();
        }

        public void change(int index, int number) {
            number2Indexes.putIfAbsent(number,new PriorityQueue<>());
             index2Number.put(index, number);
            number2Indexes.get(number).add(index);
        }

        public int find(int number) {
            PriorityQueue<Integer> priorityQueue =  number2Indexes.get(number);
            while (priorityQueue != null && !priorityQueue.isEmpty()){
                int index = priorityQueue.peek();
                Integer indexNum = index2Number.get(index);
                if (indexNum == number){
                    return index;
                }
                priorityQueue.remove();
            }
            return -1;
        }
    }

}
