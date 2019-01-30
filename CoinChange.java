package ama01;

import java.util.Arrays;

public class CoinChange {

	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(coinChange2(coins, amount));
	}
	
	public static int coinChange2(int[] coins, int amount) {
	    if(amount<1) return 0;
	    return helper2(coins, amount, new int[amount]);
	}

	private static int helper2(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
	    if(rem<0) return -1; // not valid
	    if(rem==0) return 0; // completed
	    if(count[rem-1] != 0) return count[rem-1]; // already computed, so reuse
	    int min = Integer.MAX_VALUE;
	    for(int coin : coins) {
	    	System.out.println(""+coin);
	        int res = helper2(coins, rem-coin, count);
	        if(res>=0 && res < min)
	            min = 1+res;
	    }
	    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
	    return count[rem-1];
	}
	
	
	
	
	
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
            	System.out.println("aa: "+coins[j]+"  "+i);
                if (coins[j] <= i) {
                	System.out.println(""+dp[i]+" "+coins[j]+" "+i+" dp[i]: "+dp[i]+"   "+dp[i - coins[j]] + 1);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
