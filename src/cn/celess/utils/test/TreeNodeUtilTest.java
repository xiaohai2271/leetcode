package cn.celess.utils.test;

import cn.celess.utils.TreeNodeUtil;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author : xiaohai
 * @date : 2021/03/28 17:17
 * @desc :
 */
public class TreeNodeUtilTest {
    public void testCreate() {
        /**
         * ********** 7
         * *****3***********15
         * ** ***** *****9******20
         */
        TreeNodeUtil.TreeNode tree = TreeNodeUtil.createTree(7, 3, 15, null, null, 9, 20);

        Consumer<TreeNodeUtil.TreeNode> print = treeNode -> System.out.print(treeNode + "\t");


        System.out.println("TreeNodeUtil.getDepth(tree): " + TreeNodeUtil.getDepth(tree));
        System.out.print("bfs: ");
        TreeNodeUtil.bfs(tree, print);
        System.out.println("\n先序遍历:");
        TreeNodeUtil.preorderTraversal(tree, print);
        System.out.println("\n中序遍历:");
        TreeNodeUtil.inOrderTraversal(tree, print);
        System.out.println("\n后序遍历:");
        TreeNodeUtil.subsequentTraversal(tree, print);
    }

    public static void main(String[] args) {
        new TreeNodeUtilTest().testCreate();
    }
}
