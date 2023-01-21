package personal.walker.contest;

 import personal.walker.Solution;


public class LC6253 implements Solution {
    @Override
    public void runTestCases() {

    }

    public boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        char c = arr[0].charAt(0);
        if (arr.length == 1){
            return  c == arr[0].charAt(arr[0].length() - 1);
        }
        for (int i = 1; i < arr.length; i++){
            if (i == arr.length - 1&& arr[i].charAt(arr[i].length()-1) != c){
               return false;
            }
            if (arr[i].charAt(0) != arr[i-1].charAt(arr[i-1].length()-1)){
                return false;
            }
        }
        return true;
    }

}
