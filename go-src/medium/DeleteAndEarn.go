package main

/**
 * @author : 禾几海
 * @date : 2021年05月05日 11:30
 * @difficulty : medium
 * @info submissions: 47906       accepted: 29672      acceptance: 61.94%
 * @see <a href="https://leetcode-cn.com/problems/delete-and-earn">740.删除并获得点数</a>
 * @desc :
 */
/**
// 通过下列代码成功的让我体会到这题等同于打家劫舍
// @see <a href="https://leetcode-cn.com/problems/house-robber/">198. 打家劫舍</a>
// 无用代码+1
func deleteAndEarn(nums []int) int {
	sort.Ints(nums)
	start := 0
	middle := 0
	end := 0
	result := 0
	for index := 0; index < len(nums); index++ {
		num := nums[index]
		if nums[end] != num && num != nums[middle] {
			start = middle
			middle = end
			end = index
		}
		if middle >= end {
			middle = start
		}

		tmp := 0
		for j := middle; j < end; j++ {
			tmp += nums[j]
		}
		result = max(result, tmp)
		fmt.Printf("[%-2d]\tstart:%-2d\tmiddle:%-2d\tend:%-2d\tresult:%-2d\n", index, start, middle, end, tmp)
		// 选值相加。。。。。。。
	}
	return 0
}
*/

//@lc:start
func deleteAndEarn(nums []int) int {
	// 转化为打家劫舍的问题
	maxVal := 0
	for _, val := range nums {
		maxVal = max(maxVal, val)
	}
	sum := make([]int, maxVal+1)
	for _, val := range nums {
		sum[val] += val
	}
	//  开始打家劫舍
	return rob(sum)
}

func rob(sums []int) int {
	first := 0
	second := 0

	for _, num := range sums {
		first, second = second, max(second, first+num)
	}

	return second
}
func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

//@lc:end

func main() {
	println(deleteAndEarn([]int{2, 2, 3, 3, 3, 4, 5, 5, 6, 7, 8}), "===>", 27)
}
