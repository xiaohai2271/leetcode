package cn.celess.easy;

import cn.celess.utils.*;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePreorderTraversal {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }

        //@lc:start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

        public static class Solution {
            public List<Integer> preorder(Node root) {
                List<Integer> list = new ArrayList<>();
                preorderTraversal(root, list);
                return list;
            }

            public void preorderTraversal(Node root, List<Integer> list) {
                if (root == null) return;
                list.add(root.val);
                root.children.forEach(node -> preorderTraversal(node, list));
            }
        }
        //@lc:end


        public static void main(String[] args) {
            Solution solution = new Solution();
            Assert assertion = Assert.getInstance();
        }
    }
}
