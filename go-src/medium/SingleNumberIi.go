package main

/**
 * @author : 禾几海
 * @date : 2021年04月30日 04:29
 * @difficulty : medium
 * @info submissions: 107230       accepted: 76286      acceptance: 71.14%
 * @see <a href="https://leetcode-cn.com/problems/single-number-ii">137.只出现一次的数字 II</a>
 * @desc :
 */

//@lc:start
func singleNumber(nums []int) int {
	mapping := map[int]int{}
	for _, num := range nums {
		mapping[num]++
	}
	for k, v := range mapping {
		if v == 1 {
			return k
		}
	}
	return -1
}

//@lc:end

func main() {
	print(singleNumber([]int{2, 2, 3, 2}), "\n")
	print(singleNumber([]int{0, 1, 0, 1, 0, 1, 99}))
}
