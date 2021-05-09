package main

import "fmt"

/**
 * @author : 禾几海
 * @date : 2021年05月10日 12:04
 * @difficulty : easy
 * @info submissions: 41109       accepted: 25793      acceptance: 62.74%
 * @see <a href="https://leetcode-cn.com/problems/leaf-similar-trees">872.叶子相似的树</a>
 * @desc :
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

//@lc:start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func leafSimilar(root1 *TreeNode, root2 *TreeNode) bool {
	res1, res2 := []int{}, []int{}
	analyze(root1, &res1)
	analyze(root2, &res2)

	if len(res1) != len(res2) {
		return false
	}

	for i := 0; i < len(res1); i++ {
		if res1[i] != res2[i] {
			return false
		}
	}
	return true
}

func analyze(root *TreeNode, res *[]int) {
	if root == nil {
		return
	}
	analyze(root.Left, res)
	if root.Left == nil && root.Right == nil {
		*res = append(*res, root.Val)
	}
	analyze(root.Right, res)
}

//@lc:end

func main() {
	fmt.Printf("expected: %d , actual:%d \n", 0, 0)

	r1 := TreeNode{1, nil, nil}
	r2 := TreeNode{2, nil, nil}
	println(leafSimilar(&r1, &r2))
}
