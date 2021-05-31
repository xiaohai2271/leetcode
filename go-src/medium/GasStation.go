package main

import "fmt"

/**
 * @author : 禾几海
 * @date : 2021年05月31日 02:06
 * @difficulty : medium
 * @info submissions: 184503       accepted: 105485      acceptance: 57.17%
 * @see <a href="https://leetcode-cn.com/problems/gas-station">134.加油站</a>
 * @desc :
 */
//@lc:start
func canCompleteCircuit(gas []int, cost []int) int {

	var indexs []int
	lastGas := 0

	length := len(gas)

	// 找到第一个
	for i := 0; i < length; i++ {
		lastGas += gas[i]
		lastGas -= cost[i]
		if gas[i] >= cost[i] {
			indexs = append(indexs, i)
		}
	}
	// 油量不够一圈
	if lastGas < 0 {
		return -1
	}

	lastGas = 0
	for _, index := range indexs {
		flag := true
		for j := 0; j < length; j++ {
			ind := (j + index) % length
			lastGas += gas[ind]
			lastGas -= cost[ind]
			if lastGas < 0 {
				flag = false
				continue
			}
		}
		if flag {
			return index
		}
	}
	return 0
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 3, canCompleteCircuit([]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}))
	fmt.Printf("expected: %d , actual:%d \n", -1, canCompleteCircuit([]int{2, 3, 4}, []int{3, 4, 3}))
	fmt.Printf("expected: %d , actual:%d \n", 0, canCompleteCircuit([]int{2}, []int{2}))
}
