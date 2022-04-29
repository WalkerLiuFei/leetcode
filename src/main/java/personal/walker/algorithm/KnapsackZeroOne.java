package personal.walker.algorithm;

/**
 *  零一 背包问题，
 *  有N件物品和一个容量为cap的背包。第i件物品的体积是 weights，价值是values。求解将哪些物品装入背包可使价值总和最大。
 */
public class KnapsackZeroOne{
    public static void main(String[] args) {
       // TwoDimensional(new int[]{2,3,5,7},new int[]{1,5,2,4},10);
        OneDimensional(new int[]{2,3,5,7},new int[]{1,5,2,4},10);

    }
    /**
     * 二维DP解法 : dp[i][v]表示前i件物品恰放入一个容量为v的背包可以获得的最大价值
     * 时间复杂度为O(NW), W为背包的容积
     * dp[i][v] = max(dp[i-1][v],dp[i-1][v-w[i]] + v[i])
     * @return
     */
    public static int TwoDimensional(int[] weights,int[] values,int cap){
        int[][] dp = new int[weights.length + 1][cap+1];
        for (int w = 0; w < cap; w++){
            dp[0][w] = 0;
        }

        for (int i = 1; i <= weights.length;i++){
            for(int v = 0; v <= cap;v++){
                if (weights[i-1] <= v){
                    dp[i][v] = Math.max(dp[i-1][v],dp[i-1][v-weights[i-1]] + values[i-1]);
                    System.out.printf("index %d , cap: %s, most values %s\n",i,v,dp[i][v]);
                }else {
                    dp[i][v] = dp[i-1][v];
                }
            }
        }
        return dp[weights.length][cap];
    }

    /**
     * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/%E8%83%8C%E5%8C%85%E7%90%86%E8%AE%BA%E5%9F%BA%E7%A1%8001%E8%83%8C%E5%8C%85-2.md
     * 肯定是有一个主循环i=1..N，每次算出来二维数组f[i][0..V]的所有值
     *
     * 首先想想为什么P01中要按照v=V..0的逆序来循环。这是因为要保证第i次循环中的状态f[i][v]是由状态f[i-1][v-c[i]]递推而来。
     * 换句话说，这正是为了保证每件物品只选一次，保证在考虑“选入第i件物品”这件策略时， 依据的是一个绝无已经选入第i件物品的子结果f[i-1][v-c[i]]。而现在完全背包的特点恰是每种物品可选无限件，
     * 所以在考虑“加选一件第i种物品”这种策略时，却正需要一个可能已选入第i种物品的子结果f[i][v-c[i]]，所以就可以并且必须采用v=0..V的顺序循环。
     * 这就是这个简单的程序为何成立的道理。
     *
     * @param weights
     * @param values
     * @param cap
     * @return
     *
     * 倒序遍历是为了保证物品i只被放入一次，并且是在。但如果一旦正序遍历了，那么物品0就会被重复加入多次！
     * 因为
     */
    public static int OneDimensional(int[] weights,int[] values,int cap){
        int[] dp = new int[cap+1];

        for (int i = 1; i <= weights.length;i++){
            for(int v = cap; v >= weights[i-1];v--){
                dp[v] = Math.max(dp[v],dp[v-weights[i-1]] + values[i-1]);
                System.out.printf("index %d , cap: %s, most values %s\n",i,v,dp[v]);
            }
        }
        return dp[cap];
    }
}
