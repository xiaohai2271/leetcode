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
/**
 * 动态规划——最低设置位
 * 定义正整数 xx 的「最低设置位」为 xx 的二进制表示中的最低的 11 所在位。例如，1010 的二进制表示是 1010_{(2)}1010
 * (2)
 * ​
 *  ，其最低设置位为 22，对应的二进制表示是 10_{(2)}10
 * (2)
 * ​
 *  。
 *
 * 令 y=x~\&~(x-1)y=x & (x−1)，则 yy 为将 xx 的最低设置位从 11 变成 00 之后的数，显然 0 \le y<x0≤y<x，\textit{bits}[x]=\textit{bits}[y]+1bits[x]=bits[y]+1。因此对任意正整数 xx，都有 \textit{bits}[x]=\textit{bits}[x~\&~(x-1)]+1bits[x]=bits[x & (x−1)]+1。
 *
 * 遍历从 11 到 \textit{num}num 的每个正整数 ii，计算 \textit{bits}bits 的值。最终得到的数组 \textit{bits}bits 即为答案。
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
