package main

import "math"

/**
 * @author : 禾几海
 * @date : 2021年04月28日 06:42
 * @difficulty : medium
 * @info submissions: 179697       accepted: 70246      acceptance: 39.09%
 * @see <a href="https://leetcode-cn.com/problems/sum-of-square-numbers">633.平方数之和</a>
 * @desc :
 */

//@lc:start
func judgeSquareSum(c int) bool {
	for i := 0; i*i <= c; i++ {
		rs := math.Sqrt(float64(c - i*i))
		if rs == math.Floor(rs) {
			return true
		}
	}
	return false
}

//@lc:end

func main() {
	if judgeSquareSum(5) != true {
		print("err in 5, expect is  true")
	}
	if judgeSquareSum(3) != false {
		print("err in 3, expect is false")
	}
	if judgeSquareSum(4) != true {
		print("err in 4, expect is  true")
	}
	if judgeSquareSum(2) != true {
		print("err in 2, expect is  true")
	}
	if judgeSquareSum(1) != true {
		print("err in 1, expect is  true")
	}
	if judgeSquareSum(0) != true {
		print("err in 0, expect is  true")
	}
}
