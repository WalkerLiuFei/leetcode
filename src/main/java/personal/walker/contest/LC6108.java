package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6108 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(decodeMessage("the quick brown fox jumps over the lazy dog","vkbs bs t suepuv"));
    }

    public String decodeMessage(String key, String message) {
        int[] password = new int[26];
        Arrays.fill(password,-1);
        int index = 0;
        for (byte b : key.getBytes()){
            if (b == ' '){
                continue;
            }
            if (password[b - 'a'] == -1){
                password[b - 'a'] = index++;
            }
        }
        byte[] result = new byte[message.length()];
        index = 0;
        for (byte b : message.getBytes()){
            if (b == ' '){
                result[index++] = b;
            }else {
                result[index++] = (byte)(password[b - 'a'] + 'a');
            }
        }
        return new String(result);
    }
}
