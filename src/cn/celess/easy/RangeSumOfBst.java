package cn.celess.easy;

import cn.celess.utils.*;

/**
 * @author : 禾几海
 * @date : 2021年04月27日 11:26
 * @difficulty : easy
 * @info submissions: 104123       accepted: 85076      acceptance: 81.71%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/range-sum-of-bst">938.二叉搜索树的范围和</a>
 */
public class RangeSumOfBst {

    //@lc:start

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        int result = 0;

        public int rangeSumBST(TreeNode root, int low, int high) {
            inOrderTraversal(root, low, high);
            return result;
        }

        void inOrderTraversal(TreeNode root, int low, int high) {
            if (root == null ) return;
            inOrderTraversal(root.left, low, high);
            if ( root.val >= low && root.val <= high) result+= root.val;
            inOrderTraversal(root.right, low, high);
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new RangeSumOfBst().new Solution();
        Assert assertion = Assert.getInstance();
        System.out.println(solution.rangeSumBST(TreeNodeUtil.createTree(10, 5, 15, 3, 7, null, 18), 7, 15));
        System.out.println(); System.out.println(solution.rangeSumBST(TreeNodeUtil.createTree(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10));
    }
}
