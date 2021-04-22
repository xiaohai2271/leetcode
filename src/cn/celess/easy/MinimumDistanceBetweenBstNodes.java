package cn.celess.easy;

import cn.celess.utils.*;
import cn.celess.utils.TreeNodeUtil.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MinimumDistanceBetweenBstNodes {

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

        public int minDiffInBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            int minVal = Integer.MAX_VALUE;
            TreeNode preNode = null;

            while (root != null || !stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (preNode != null) {
                    minVal = Math.min(minVal, root.val - preNode.val);
                }
                preNode = root;
                root = root.right;
            }
            return minVal;
        }

        public int minDiffInBST_1(TreeNode root) {
            List<Integer> list = new ArrayList<>();
            inOrderTraversal(root, list);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Math.min(list.get(i) - list.get(i - 1), min);
            }
            return min;
        }

        public void inOrderTraversal(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inOrderTraversal(root.left, list);
            list.add(root.val);
            inOrderTraversal(root.right, list);
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        Assert assertion = Assert.getInstance();
        TreeNode tree = TreeNodeUtil.createTree(4, 2, 6, 1, 3);
        System.out.println(
                solution.minDiffInBST(tree)
        );
        tree = TreeNodeUtil.createTree(90, 69, null, 49, 89, null, 52);
        System.out.println(
                solution.minDiffInBST(tree)
        );
        tree = TreeNodeUtil.createTree(1, 0, 48, null, null, 12, 49);
        System.out.println(
                solution.minDiffInBST(tree)
        );
    }
}
