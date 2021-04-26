package cn.celess.easy;

import cn.celess.utils.*;
import cn.celess.utils.TreeNodeUtil.*;

import java.util.function.Consumer;

/**
 * @author : 禾几海
 * @date : 2021年04月25日 07:32
 * @difficulty : easy
 * @info submissions: 63526       accepted: 47385      acceptance: 74.59%
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/increasing-order-search-tree">897.递增顺序搜索树</a>
 */
public class IncreasingOrderSearchTree {

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
        private TreeNode res;

        public TreeNode increasingBST(TreeNode root) {
            TreeNode newNode = new TreeNode(-1);
            res = newNode;
            inOrderTraversal(root);
            return newNode.right;
        }

        void inOrderTraversal(TreeNode root) {
            if (root == null) return;
            inOrderTraversal(root.left);

            root.left = null;
            res.right = root;
            res = root;

            inOrderTraversal(root.right);
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new IncreasingOrderSearchTree().new Solution();
        Assert assertion = Assert.getInstance();
        TreeNode tree = TreeNodeUtil.createTree(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9);
        TreeNode treeNode = solution.increasingBST(tree);
        Consumer print = ints -> System.out.print(ints + "\t");
        TreeNodeUtil.bfs(treeNode, print);

        tree = TreeNodeUtil.createTree(2, 1, 4, null, null, 3);
        treeNode = solution.increasingBST(tree);
        TreeNodeUtil.bfs(treeNode, print);
    }
}
