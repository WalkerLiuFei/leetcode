package personal.walker.algorithm;

// https://oi-wiki.org/ds/seg/
public class SegmentTree {

    public static void main(String[] args) {
        SumQuestion sumQuestion = new SumQuestion(new int[]{1,2,3,4,5,6});
        sumQuestion.build();
        for (int e : sumQuestion.getResult()){
            System.out.printf("%d\n",e);
        }
        System.out.println(sumQuestion.querySumBetween(0,3));
    }

    static class SumQuestion {
        private int[] src;
        private int[] result;

        public int[] getResult() {
            return result;
        }

        SumQuestion(int[] srcArray){
            this.src = srcArray;
            result = new int[srcArray.length * 4];
        }
        public int querySumBetween(int i,int j){
            // index 0的值就是 [0,src.length -1]的 sum值
            return queryHelper(i,j,0,src.length -1,1);
        }
        public int queryHelper(int l,int r,int s,int t,int p){
            // 当前的区间完全被查询区间包含
            if (l <= s && r >= t){
                return result[p];
            }
            int m = s + ((t - s) >> 1);
            int sum = 0;
            // 如果{左儿子}代表的区间 [s, m] 与询问区间有交集, 则递归查询左儿子
            if (l <= m) {
                sum += queryHelper(l,r,s,m,p * 2);
            }
            // 如果{右儿子}树代表的区间 [m+1,end] 与询问区间有交集, 则递归查询右儿子
            if (m < r){
                sum += queryHelper(l,r,m+1,t,p * 2 + 1);
            }
            return sum;
        }

        public void build(){
            doBuild(1,0,src.length - 1);
        }

        private void doBuild(int i, int start, int end){
            if (start == end){
                result[i] = src[start];
                return;
            }
            int m = start + ((end - start) >> 1 );
            doBuild(i * 2,start,m);
            doBuild(i * 2 + 1,m+1,end);
            result[i] = result[i * 2] + result[i * 2 + 1];
        }
    }
}
