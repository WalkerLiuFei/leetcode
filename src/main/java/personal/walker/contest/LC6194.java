package personal.walker.contest;

import personal.walker.Solution;

public class LC6194 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(minimizeXor(3,5));
        System.out.println(minimizeXor(3,1));
        System.out.println(minimizeXor(1,12));
        System.out.println(minimizeXor(25, 72));
        System.out.println(Integer.toBinaryString(25));
        System.out.println(Integer.toBinaryString(72));

        System.out.println(minimizeXor(65,84));
        System.out.println(Integer.toBinaryString(65));
        System.out.println(Integer.toBinaryString(84));
    }

    public int minimizeXor(int num1, int num2) {
        // 找到和num1
        int num2Cpy = num2;
        int setBitsCount = 0;
        while (num2Cpy != 0) {
            if ((num2Cpy & 0x01) != 0) {
                setBitsCount++;
            }
            num2Cpy >>= 1;
        }

        int result = 0;

        String num1BinaryString = Integer.toBinaryString(num1);
        for (int i = 0; i < num1BinaryString.length() && setBitsCount > 0; i++) {
            if (num1BinaryString.charAt(i) == '1') {
                result |= (1 << num1BinaryString.length() - i - 1);
                setBitsCount--;
            }
        }
        if (setBitsCount > 0) {
            int resultCpy = result;
            int i = 0;
            while (resultCpy > 0 && setBitsCount > 0){
                if ((resultCpy & 0x01) == 0){
                    result |= 0x01 << i;
                    setBitsCount--;
                }
                resultCpy >>= 1;
                i++;
            }
            while (setBitsCount > 0){
                result |= 0x01 << i++;
                setBitsCount--;
            }
        }


        return result;
    }
}
