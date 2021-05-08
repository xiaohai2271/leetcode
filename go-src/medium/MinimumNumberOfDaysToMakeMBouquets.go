package main

import (
	"fmt"
	"sort"
)

/**
 * @author : 禾几海
 * @date : 2021年05月09日 12:21
 * @difficulty : medium
 * @info submissions: 13117       accepted: 6242      acceptance: 47.59%
 * @see <a href="https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets">1482.制作 m 束花所需的最少天数</a>
 * @desc :
 */
//@lc:start
func minDays(bloomDay []int, m int, k int) int {
	if m*k > len(bloomDay) {
		return -1
	}
	maxDay := 0
	for _, day := range bloomDay {
		if day > maxDay {
			maxDay = day
		}
	}

	//low, high := 0, maxDay
	//
	//middle := 0
	//for low < high {
	//	middle = low + (high-low)/2
	//	if canMake(bloomDay, middle, m, k) {
	//		high = middle
	//	} else {
	//		low = middle + 1
	//	}
	//}
	//return low

	// 使用二分查找库
	return sort.Search(maxDay, func(day int) bool {
		return canMake(bloomDay, day, m, k)
	})
}
func canMake(bloomDay []int, day, m, k int) bool {
	count := 0
	tmpK := 0

	for _, d := range bloomDay {
		tmpK = If(d > day, 0, tmpK+1)

		if tmpK == k {
			count++
			tmpK = 0
		}
	}
	return count >= m
}

// If 代替三元表达式
func If(condition bool, a, b int) int {
	if condition {
		return a
	}
	return b
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 3, minDays([]int{1, 10, 3, 10, 2}, 3, 1))
	fmt.Printf("expected: %d , actual:%d \n", -1, minDays([]int{1, 10, 3, 10, 2}, 3, 2))
	fmt.Printf("expected: %d , actual:%d \n", 12, minDays([]int{7, 7, 7, 7, 12, 7, 7}, 2, 3))
	fmt.Printf("expected: %d , actual:%d \n", 1000000000, minDays([]int{1000000000, 1000000000}, 1, 1))
	fmt.Printf("expected: %d , actual:%d \n", 9, minDays([]int{1, 10, 2, 9, 3, 8, 4, 7, 5, 6}, 4, 2))
	fmt.Printf("expected: %d , actual:%d \n", 93, minDays([]int{5, 37, 55, 92, 22, 52, 31, 62, 99, 64, 92, 53, 34, 84, 93, 50, 28}, 8, 2))
}
