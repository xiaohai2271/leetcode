package main

import (
	"fmt"
)

/**
 * @author : 禾几海
 * @date : 2021年05月07日 10:49
 * @difficulty : medium
 * @info submissions: 516223       accepted: 223626      acceptance: 43.32%
 * @see <a href="https://leetcode-cn.com/problems/coin-change">322.零钱兑换</a>
 * @desc :
 */

//@lc:start
func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	dp[0] = 0
	for i := 1; i <= amount; i++ {
		dp[i] = amount + 1
		for _, coin := range coins {
			if coin <= i {
				dp[i] = min(dp[i], dp[i-coin]+1)
			}
		}
	}
	// so ugly why not `dp[amount] > amount ? -1 : dp[amount]`
	if dp[amount] > amount {
		return -1
	}
	return dp[amount]
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 3, coinChange([]int{1, 2, 5}, 11))
	fmt.Printf("expected: %d , actual:%d \n", -1, coinChange([]int{2}, 3))
	fmt.Printf("expected: %d , actual:%d \n", 0, coinChange([]int{1}, 0))
	fmt.Printf("expected: %d , actual:%d \n", 1, coinChange([]int{1}, 1))
	fmt.Printf("expected: %d , actual:%d \n", 2, coinChange([]int{1}, 2))
}
