package leetcode.medium;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i ++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                int left = i - coins[j];
                if(left < 0){
                    continue;
                }
                if(dp[left] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[left] + 1);
                }
            }
        }

        // for(int i = 0; i <= amount; i ++){
        //     System.out.print(dp[i] + ",");
        // }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}
