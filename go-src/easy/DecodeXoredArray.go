package main

import "fmt"

/**
 * @author : 禾几海
 * @date : 2021年05月06日 08:38
 * @difficulty : easy
 * @info submissions: 15719       accepted: 13516      acceptance: 85.99%
 * @see <a href="https://leetcode-cn.com/problems/decode-xored-array">1720.解码异或后的数组</a>
 * @desc :
 */

//@lc:start
func decode(encoded []int, first int) []int {
	//x^x = 0, 0^y = y	===>	a^b = c, c^a = a^b^a = b
	arr := make([]int, len(encoded)+1)
	arr[0] = first
	for index := 1; index <= len(encoded); index++ {
		arr[index] = encoded[index-1] ^ arr[index-1]
	}
	return arr
}

//@lc:end

func main() {
	fmt.Println(decode([]int{1, 2, 3}, 1))
	fmt.Println(decode([]int{6, 2, 7, 3}, 4))
}
