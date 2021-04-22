
package cn.celess.medium.T61;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        ListNode pHead = head;

        int len = 1;
        while (pHead.next != null) {
            pHead = pHead.next;
            len++;
        }

        pHead.next = head;

        for (int i = 0; i < len - (k % len); i++) {
            pHead = pHead.next;
        }
        head = pHead.next;
        pHead.next = null;
        return head;
    }
}
// @lc code=end

class Test {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(5);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode node = new ListNode(1, node1);
        each(node);

        Solution solution = new Solution();
        each(solution.rotateRight(node, 2));

        ListNode node_1 = new ListNode(2);
        ListNode node_0 = new ListNode(1, node_1);
        each(node_0);
        each(solution.rotateRight(node_0, 3));

    }

    public static void each(ListNode head) {
        System.out.println("result:");
        if (head == null)
            return;
        ListNode p = head;
        StringBuffer sb = new StringBuffer();
        sb.append(p.val);
        p = p.next;
        while (p != null) {
            sb.append(" --> ");
            sb.append(p.val);
            p = p.next;
        }
        System.out.println(sb.toString());
    }
}
