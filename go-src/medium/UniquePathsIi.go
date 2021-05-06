package main

/**
 * @author : 禾几海
 * @date : 2021年05月07日 12:03
 * @difficulty : medium
 * @info submissions: 371971       accepted: 141896      acceptance: 38.15%
 * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii">63.不同路径 II</a>
 * @desc :
 */

//@lc:start
func uniquePathsWithObstacles(obstacleGrid [][]int) int {
	m := len(obstacleGrid)
	n := len(obstacleGrid[0])
	dp := make([][]int, m)
	for i, _ := range dp {
		dp[i] = make([]int, n)
		// 检测边界情况 遇到石头就躲避
		if obstacleGrid[i][0] == 1 {
			dp[i][0] = 0
			continue
		}
		if i > 0 {
			dp[i][0] = dp[i-1][0]
			continue
		}
		dp[i][0] = 1
	}

	for j := 1; j < n; j++ {
		// 检测边界情况 遇到石头就躲避
		if obstacleGrid[0][j] == 1 {
			dp[0][j] = 0
			continue
		}
		dp[0][j] = dp[0][j-1]
		continue
	}
	for i := 1; i < m; i++ {
		for j := 1; j < n; j++ {
			if obstacleGrid[i][j] == 1 {
				dp[i][j] = 0
				continue
			}
			dp[i][j] = dp[i-1][j] + dp[i][j-1]
		}
	}
	return dp[m-1][n-1]
}

//@lc:end

func main() {
	println(uniquePathsWithObstacles([][]int{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}), "\n")
	println(uniquePathsWithObstacles([][]int{{0, 1}, {0, 0}}), "\n")
	println(uniquePathsWithObstacles([][]int{{1, 0}}), "\n")
	println(uniquePathsWithObstacles([][]int{{1}, {0}}), "\n")
}
