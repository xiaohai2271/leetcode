package main

import (
	"fmt"
	"sort"
)

/**
 * @author : 禾几海
 * @date : 2021年05月10日 03:06
 * @difficulty : medium
 * @info submissions: 10622       accepted: 2928      acceptance: 27.57%
 * @see <a href="https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls">1648.销售价值减少的颜色球</a>
 * @desc :
 */

//		//if res > 10E9+7-inventory[len-1] {
//		//	res -= 10E9 + 7
//		//}
//		//res += inventory[len-1]
//		//inventory[len-1]--
//		//sort.Ints(inventory)
//		//
//		//if res > 10E9+7-inventory[len-1] {
//		//	res -= 10E9 + 7
//		//}
//@lc:start
// 简单贪心 优化后还是超时
func maxProfit1(inventory []int, orders int) int {
	sort.Ints(inventory)
	const MOD = 1000000007
	res := 0

	min := func(a, b int) int {
		if a < b {
			return a
		}
		return b
	}

	addition := 0
	arrLen := len(inventory)

	if arrLen == 1 {
		return ((inventory[0] + inventory[0] - orders + 1) * orders / 2) % MOD
	}

	for orders > 0 {
		res += (inventory[arrLen-1] + inventory[arrLen-2] + 1) * addition / 2
		inventory[arrLen-1] -= addition
		orders -= addition
		sort.Ints(inventory)

		addition = min(inventory[arrLen-1]-inventory[arrLen-2], orders)
		if addition == 0 {
			addition++
		}
	}
	//fmt.Println(10E9 + 7)
	return res % MOD
}

// 算法有错误
func maxProfit3(inventory []int, orders int) int {
	maxNum := 0
	for _, num := range inventory {
		if maxNum < num {
			maxNum = num
		}
	}
	num := 0
	t := sort.Search(maxNum, func(t int) bool {
		num = 0
		for _, ball := range inventory {
			if ball >= t {
				num += ball - t + 1
			}
		}
		fmt.Println(t, "--->", num)
		return num <= orders
	})

	fmt.Println(t, "sum", num)
	ans := 0
	count := 0
	// 此处的计算有问题
	for _, ball := range inventory {
		if ball == t {
			ans += ball
		}
		if ball > t {
			count += ball - t
			ans = (ans + (t+1+ball)*(ball-t)/2) % (10e+7)
		}
	}
	ans = (ans + t*(orders-count)) % (10e+7)
	return ans
}
func maxProfit2(inventory []int, orders int) int {
	const MOD = 1000000007

	l, r := 0, int(1e9)

	getCount := func(mid int) int {
		count := 0
		for i := range inventory {
			if inventory[i] > mid {
				count += inventory[i] - mid
			}
		}
		return count
	}

	sum := func(i, j int) int {
		// n*a1 + n*(n-1)/2
		a1, n := i+1, j-i
		return n*a1 + n*(n-1)/2
	}

	for l < r {
		mid := (l + r) >> 1
		count := getCount(mid)
		if count < orders {
			r = mid
		} else {
			l = mid + 1
		}
	}

	res := (orders - getCount(l)) * l

	for i := range inventory {
		if inventory[i] > l {
			res += (sum(l, inventory[i])) % MOD
		}
	}

	return res % MOD

}

func maxProfit(inventory []int, orders int) int {
	return maxProfit2(inventory, orders)
}

//@lc:end
