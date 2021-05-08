package main

import (
	"fmt"
	"math"
)

/**
 * @author : 禾几海
 * @date : 2021年05月08日 10:44
 * @difficulty : hard
 * @info submissions: 34003       accepted: 16971      acceptance: 49.91%
 * @see <a href="https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs">1723.完成所有工作的最短时间</a>
 * @desc :
 */
//@lc:start
func minimumTimeRequired(jobs []int, k int) int {
	result := math.MaxInt64
	backTrace(&result, jobs, 0, make([]int, k), 0)
	return result
}

func backTrace(result *int, jobs []int, i int, worker []int, maxN int) {
	if i == len(jobs) {
		*result = If(*result < maxN, *result, maxN)
		return
	}
	mm := map[int]bool{}
	for j := 0; j < len(worker); j++ {
		if mm[worker[j]] || worker[j]+jobs[i] >= *result {
			continue
		} else if !mm[worker[j]] {
			mm[worker[j]] = true
		}
		worker[j] += jobs[i]
		backTrace(result, jobs, i+1, worker, If(worker[j] > maxN, worker[j], maxN))
		worker[j] -= jobs[i]
	}
}

func If(condition bool, a, b int) int {
	if condition {
		return a
	}
	return b
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 3, minimumTimeRequired([]int{3, 2, 1}, 3))
	fmt.Printf("expected: %d , actual:%d \n", 11, minimumTimeRequired([]int{1, 2, 4, 7, 8}, 2))
	fmt.Printf("expected: %d , actual:%d \n", 9899456, minimumTimeRequired([]int{9899456, 8291115, 9477657, 9288480, 5146275, 7697968, 8573153, 3582365, 3758448, 9881935, 2420271, 4542202}, 9))
}
