package main

/**
 * @author : 禾几海
 * @date : 2021年05月07日 08:26
 * @difficulty : easy
 * @info submissions: 42653       accepted: 36051      acceptance: 84.52%
 * @see <a href="https://leetcode-cn.com/problems/xor-operation-in-an-array">1486.数组异或操作</a>
 * @desc :
 */

//@lc:start
func xorOperation(n int, start int) (ans int) {
	for i := 0; i < n; i++ {
		ans ^= start + i*2
	}
	return ans
}

/**
// O(1) 时间的解法
func sumXor(x int) int {
    switch x % 4 {
    case 0:
        return x
    case 1:
        return 1
    case 2:
        return x + 1
    default:
        return 0
    }
}

func xorOperation(n, start int) (ans int) {
    s, e := start>>1, n&start&1
    ret := sumXor(s-1) ^ sumXor(s+n-1)
    return ret<<1 | e
}
*/

//@lc:end

func main() {
	println(8, xorOperation(5, 0))
	println(8, xorOperation(4, 3))
	println(7, xorOperation(1, 7))
	println(2, xorOperation(10, 5))
}
