package cn.celess.utils;

import java.util.*;
import java.util.function.Consumer;
/**
 * @author : xiaohai
 * @date : 2021/03/28 16:47
 * @desc :
 */
public class TreeNodeUtil {

    public static TreeNode createTree(Integer... values) {
        if (values.length == 0) return null;
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        TreeNode root = new TreeNode(values[0]);
        nodeQueue.add(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode poll = nodeQueue.poll();
            if (poll == null) return root;
            Integer left = values[i];
            Integer right = null;
            if (i < values.length - 1) right = values[i + 1];
            if (left != null) {
                poll.left = new TreeNode(left);
                nodeQueue.add(poll.left);
            }
            if (right != null) {
                poll.right = new TreeNode(right);
                nodeQueue.add(poll.right);
            }
        }
        return root;
    }

    public static void bfs(TreeNode root, Consumer<TreeNode> treeNodeConsumer) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int size = (int) (Math.pow(2, getDepth(root)) - 1);
        while (!nodeQueue.isEmpty()) {
            TreeNode poll = nodeQueue.poll();
            if (size == 0) {
                break;
            }
            treeNodeConsumer.accept(poll);
            size--;
            if (poll == null) {
                continue;
            }
            nodeQueue.add(poll.left);
            nodeQueue.add(poll.right);
        }
    }

    public static void dfs(TreeNode root, Consumer<TreeNode> treeNodeConsumer) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // do here
            treeNodeConsumer.accept(root);
            root = root.right;
        }
    }

    public static void preorderTraversal(TreeNode root, Consumer<TreeNode> treeNodeConsumer) {
        if (root == null) return;
        treeNodeConsumer.accept(root);
        preorderTraversal(root.left, treeNodeConsumer);
        preorderTraversal(root.right, treeNodeConsumer);
    }

    public static void inOrderTraversal(TreeNode root, Consumer<TreeNode> treeNodeConsumer) {
        if (root == null) return;
        inOrderTraversal(root.left, treeNodeConsumer);
        treeNodeConsumer.accept(root);
        inOrderTraversal(root.right, treeNodeConsumer);
    }

    public static void subsequentTraversal(TreeNode root, Consumer<TreeNode> treeNodeConsumer) {
        if (root == null) return;
        subsequentTraversal(root.left, treeNodeConsumer);
        subsequentTraversal(root.right, treeNodeConsumer);
        treeNodeConsumer.accept(root);
    }

    public static int getDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
