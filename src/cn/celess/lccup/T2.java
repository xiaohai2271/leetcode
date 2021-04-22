package cn.celess.lccup;

import cn.celess.utils.Assert;
import cn.celess.utils.TreeNodeUtil;
import cn.celess.utils.TreeNodeUtil.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : xiaohai
 * @date : 2021/04/10 14:52
 * @desc :
 */
public class T2 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int maxValue(TreeNode root, int k) {
            int count = k;

            List<TreeNode> nodes = new ArrayList<>();
            preorderTraversal(root, nodes);
            nodes.sort((node1, node2) -> node2.val - node1.val);
            List<TreeNode> result = new ArrayList<>();

            result.add(nodes.get(0));
            count--;

            for (TreeNode node : nodes) {
                if (count == 0) {
                    continue;
                }
                count--;
//                while (node.)
            }

            System.out.println(nodes);
            return 0;

        }

        public void preorderTraversal(TreeNode root, List<TreeNode> nodes) {
            if (root == null) return;
            nodes.add(root);
            preorderTraversal(root.left, nodes);
            preorderTraversal(root.right, nodes);
        }
    }


    public static void main(String[] args) {
        Assert assertion = Assert.getInstance();
        TreeNode tree = TreeNodeUtil.createTree(4, 1, 3, 9, null, null, 2);
        Solution solution = new T2().new Solution();
        solution.maxValue(tree, 10);
    }
}
