package personal.walker;

public class OneEditAway implements Solution {
    @Override
    public void runTestCases() {

    }

    /**
     * pale
     * ple
     * i = 0...3
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.length() == second.length()) {
            boolean flag = false;
            for (int i = 0; i < first.length(); i++) {
                if (flag && first.charAt(i) != second.charAt(i)){
                    return false;
                }
                flag = first.charAt(i) != second.charAt(i);
            }
            return true;
        }
        int i = 0;
        int j = 0;
        // 寻找第一个不同的 index
        while (i < first.length() && j < second.length() && first.charAt(i++) == second.charAt(j++)) {}
        if (i == first.length() || j == second.length() ){
            return  true;
        }
        // first
        if (first.charAt(i + 1) == second.charAt(j)){i++;}
        else if (first.charAt(i ) == second.charAt(j + 1)){j++;}
        else if (first.charAt(i+1) == second.charAt(j +1)){i++;j++;}

        while (i < first.length() && j < second.length() && first.charAt(i++) == second.charAt(j++)) {}

        return i == first.length() && j == second.length();
    }
}
