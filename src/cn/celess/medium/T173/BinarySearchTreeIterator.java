package cn.celess.medium.T173;

import cn.celess.utils.*;
import cn.celess.utils.TreeNodeUtil.*;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

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
    class BSTIterator {
        private List<Integer> array;
        private int index;

        public BSTIterator(TreeNode root) {
            index = 0;
            array = new ArrayList<>();
            inOrderTraversal(root, array);
        }

        public int next() {
            return array.get(index++);
        }

        public boolean hasNext() {
            return index != array.size();
        }

        private void inOrderTraversal(TreeNode root, List<Integer> array) {
            if (root != null) {
                inOrderTraversal(root.left, array);
                array.add(root.val);
                inOrderTraversal(root.right, array);
            }
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */
    //@lc:end
    public static void main(String[] args) {
        BSTIterator solution = new BinarySearchTreeIterator().new BSTIterator(null);
        Assert assertion = Assert.getInstance();
    }
}
