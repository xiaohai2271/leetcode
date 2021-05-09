package main

import "fmt"

/**
 * @author : 禾几海
 * @date : 2021年05月09日 02:15
 * @difficulty : medium
 * @info submissions: 13980       accepted: 3573      acceptance: 25.56%
 * @see <a href="https://leetcode-cn.com/problems/maximum-value-at-a-given-index-in-a-bounded-array">1802.有界数组中指定下标处的最大值</a>
 * @desc :
 */
// 最开始自己的想法
// num 记录index位置的值  慢慢增加该值 判断整个数组的数值之和 sum 是否超过maxSum
// 未超过还可继续新增sum
// 超过则返回sum-1 上次尝试的值

// !!! 当n/maxSum 数值量比较大的时候 此方法极易超时，所以此处引入一个系数${factor}
// 这个系数默认为1，即上述的思想

// 当每次新增的值为一个固定值${before}+${after}时 即类似于对数组[2,3,4,5,6,5] 增加index处的值时  整个数组的和增加n（包含index处）
// 此时我们即可启用这个系数，让他倍增2 此时每次执行次数相当于跳过原思路的对数
// 当我们使用系数新增得到的值超过了maxSum 我们即回退系数，让其回退到他的一半，然后接着进行计算
// 最终我们即可得符合题意的值

//@lc:start
func maxvalue1(n int, index int, maxSum int) int {
	num := 1
	sum := n

	before, after := 0, 0
	factor := 1

	for sum < maxSum {
		num += factor
		sum += (before + after + 1) * factor
		if after < n-index-1 {
			after++
		}
		if before < index {
			before++
		}

		if sum > maxSum {
			if factor == 1 {
				return num - 1
			}
			// 降因子 还原现场
			sum -= (before + after + 1) * factor
			num -= factor
			factor /= 2
			continue
		}
		if before+after == n-1 {
			// 加速 使用倍增因子
			factor *= 2
		}
	}

	return num
}
func maxvalue2(n int, index int, maxSum int) int {
	low, high := 1, maxSum+1
	middle, res := 0, 0
	for low < high {
		middle = low + (high-low)/2
		if check(middle, n, index, maxSum) {
			low, res = middle+1, middle
		} else {
			high = middle
		}
	}
	return res
}

// check1 此方法会超时 建议使用 check
// 此方法 累加整个数组的值 判断是否符合条件  !!效率低!!
func check1(sum, n, index, maxSum int) bool {
	maxSum -= sum
	cur := sum - 1
	for i := 1; i < n; i++ {
		if index+i < n {
			maxSum -= cur
		}
		if index-i >= 0 {
			maxSum -= cur
		}
		if cur > 1 {
			cur--
		}
	}
	return maxSum >= 0
}

// check 检查当 array[index] = sum 数组是否符合题目要求
// 使用等差公式计算值
func check(sum, n, index, maxSum int) bool {
	// 左边
	leftEnd := index - sum
	if leftEnd >= 0 {
		maxSum -= getDifferSum(sum-1, sum)
		maxSum -= index - sum + 1
	} else {
		maxSum -= getDifferSum(sum-1, index)
	}
	rightEnd := index + sum
	if rightEnd < n {
		maxSum -= getDifferSum(sum-1, sum)
		maxSum -= n - rightEnd
	} else {
		maxSum -= getDifferSum(sum-1, n-index-1)
	}
	return maxSum-sum >= 0
}
func getDifferSum(a1, n int) int {
	return n*a1 - (n * (n - 1) / 2)
}

func maxValue(n int, index int, maxSum int) int {
	//return maxvalue1(n, index, maxSum)
	return maxvalue2(n, index, maxSum)
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 2, maxValue(4, 2, 6))
	fmt.Printf("expected: %d , actual:%d \n", 3, maxValue(6, 1, 10))
	fmt.Printf("expected: %d , actual:%d \n", 7, maxValue(3, 2, 18))
	fmt.Printf("expected: %d , actual:%d \n", 24, maxValue(1, 0, 24))
	fmt.Printf("expected: %d , actual:%d \n", 271698267, maxValue(3, 0, 815094800))
	fmt.Printf("expected: %d , actual:%d \n", 444029221, maxValue(1, 0, 444029221))
	fmt.Printf("expected: %d , actual:%d \n", 3, maxValue(9, 3, 16))
	fmt.Printf("expected: %d , actual:%d \n", 26281, maxValue(9583420, 3647043, 700255991))
}
