package main

import (
	"fmt"
)

/**
 * @author : 禾几海
 * @date : 2021年05月07日 12:35
 * @difficulty : medium
 * @info submissions: 162508       accepted: 128087      acceptance: 78.82%
 * @see <a href="https://leetcode-cn.com/problems/counting-bits">338.比特位计数</a>
 * @desc :
 */
//@lc:start
func countBits(num int) []int {
	dp := make([]int, num+1)
	dp[0] = 0
	for i := 1; i <= num; i++ {
		dp[i] = 1 + dp[i&(i-1)]
	}
	return dp
}

//@lc:end

func main() {
	//fmt.Printf("expected: %d , actual:%d \n", 0, 0)
	//fmt.Println(countBits(2))
	//fmt.Println(countBits(5))
	//[0,1,1,2,1,2,2,3,1]
	fmt.Println(countBits(16))
}
