package personal.walker.algorithm;

/**
 * 完全背包问题
 * 有N件物品和一个容量为v的背包。第i件物品的体积是 weights，价值是values,并且每件商品有无限多个，求解将哪些物品装入背包可使价值总和最大。
 * 通过01背包问题可得 ： dp[i][v] = max(dp[i-1][v - k*weight[i]]  + k * values[i] | 0 <= k * weights[i] <= v)
 */
public class KnapsackComplete {

    public static int OneDimensional(int[] weights,int[] values,int cap){
        int[] dp = new int[cap+1];

        for (int i = 1; i <= weights.length;i++){
            // 容积从零开始计，就是当前物品 weights[i]可以放n次
            for(int v = 0; v >= cap - weights[i-1];v--){
                dp[v] = Math.max(dp[v],dp[v-weights[i-1]] + values[i-1]);
                System.out.printf("index %d , cap: %s, most values %s\n",i,v,dp[v]);
            }
        }
        return dp[cap];
    }
}
