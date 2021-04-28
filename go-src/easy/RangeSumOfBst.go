package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

/**
 * @author : 禾几海
 * @date : 2021年04月28日 07:18
 * @difficulty : easy
 * @info submissions: 106596       accepted: 87191      acceptance: 81.80%
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst">938.二叉搜索树的范围和</a>
 * @desc :
 */

//@lc:start
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//var result = 0

func rangeSumBST(root *TreeNode, low int, high int) int {
	//result = 0
	return inOrderTraversal(root, low, high)
	//return result
}

//func inOrderTraversal_1(root *TreeNode, low int, high int) {
//	if root == nil {
//		return
//	}
//	inOrderTraversal_1(root.Left, low, high)
//	if root.Val >= low && root.Val <= high {
//		result += root.Val
//	}
//	inOrderTraversal_1(root.Right, low, high)
//}

func inOrderTraversal(root *TreeNode, low int, high int) int {
	if root == nil {
		return 0
	}
	if root.Val < low {
		return inOrderTraversal(root.Right, low, high)
	}
	if root.Val > high {
		return inOrderTraversal(root.Left, low, high)
	}
	return root.Val + inOrderTraversal(root.Left, low, high) + inOrderTraversal(root.Right, low, high)
}

//@lc:end

func main() {
}
