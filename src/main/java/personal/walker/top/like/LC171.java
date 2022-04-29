package personal.walker.top.like;

public class LC171 {

    public void runTestCases(){
        int result = titleToNumber("Y");
        System.out.println(result);
    }

    /**
     * 其实很简单，就是26进制转 10进制
     */
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int index = columnTitle.length()  - 1 ;index >= 0;index--){
            result +=  (columnTitle.charAt(index) - 'A' + 1) *  Math.pow(26,columnTitle.length()  - 1 - index)  ;
        }
        return result;
    }
}
