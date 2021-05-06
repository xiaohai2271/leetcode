package main

/**
 * @author : 禾几海
 * @date : 2021年05月06日 11:25
 * @difficulty : medium
 * @info submissions: 378130       accepted: 245767      acceptance: 65.00%
 * @see <a href="https://leetcode-cn.com/problems/unique-paths">62.不同路径</a>
 * @desc :
 */

//@lc:start
func uniquePaths(m int, n int) int {
	dp := make([][]int, m)
	for i, _ := range dp {
		dp[i] = make([]int, n)
		dp[i][0] = 1
	}

	for j := 0; j < n; j++ {
		dp[0][j] = 1
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}

	return dp[m-1][n-1]
}

//@lc:end

func main() {
	println(uniquePaths(3, 7))
}
