package main

import "fmt"

/**
 * @author : 禾几海
 * @date : 2021年05月09日 02:01
 * @difficulty : easy
 * @info submissions: 6836       accepted: 5562      acceptance: 81.36%
 * @see <a href="https://leetcode-cn.com/problems/minimum-operations-to-make-the-array-increasing">1827.最少操作使数组递增</a>
 * @desc :
 */
//@lc:start
func minOperations(nums []int) int {
	result := 0

	for i := 1; i < len(nums); i++ {
		if nums[i-1] >= nums[i] {
			result += nums[i-1] - nums[i] + 1
			nums[i] = nums[i-1] + 1
		}
	}
	return result
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 3, minOperations([]int{1, 1, 1}))
	fmt.Printf("expected: %d , actual:%d \n", 14, minOperations([]int{1, 5, 2, 4, 1}))
	fmt.Printf("expected: %d , actual:%d \n", 0, minOperations([]int{8}))
}
