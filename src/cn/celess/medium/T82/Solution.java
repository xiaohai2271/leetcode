package cn.celess.medium.T82;

import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    // 哈希表法
    public ListNode deleteDuplicates_1(ListNode head) {
        if (head == null)
            return null;
        Map<Integer, Integer> countMap = new HashMap<>();
        ListNode nodePoint = head;
        while (nodePoint != null) {
            countMap.put(nodePoint.val, countMap.getOrDefault(nodePoint.val, 0) + 1);
            nodePoint = nodePoint.next;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode preNode = newHead;
        nodePoint = head;
        while (nodePoint != null) {
            if (countMap.get(nodePoint.val) != 1) {
                // 删除
                preNode.next = nodePoint.next;
                nodePoint = nodePoint.next;
                continue;
            }
            preNode = nodePoint;
            nodePoint = nodePoint.next;
        }

        return newHead.next;
    }

    // 向后查找法
    public ListNode deleteDuplicates_2(ListNode head) {
        if (head == null)
            return null;

        ListNode newHead = new ListNode(0, head);
        ListNode current = newHead;
        while (current.next != null && current.next.next != null) {
            if (current.next.val == current.next.next.val) {
                int x = current.next.val;

                while (current.next != null && current.next.val == x) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return newHead.next;
    }

    // 递归法
    public ListNode deleteDuplicates(ListNode head) {
        // ListNode newHead = new ListNode(0, head);

        if (head != null && head.next != null) {
            return head;
        }
        if (head.val == head.next.val) {
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
// @lc code=end

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

class Test {
    public static void main(String[] args) {
        ListNode node6 = new ListNode(5);
        ListNode node5 = new ListNode(4, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode head = new ListNode(1, node1);
        each(head);
        Solution s = new Solution();
        each(s.deleteDuplicates(head));
        node1 = new ListNode(1);
        head = new ListNode(1, node1);
        each(head);
        each(s.deleteDuplicates(head));
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
            sb.append("->");
            sb.append(p.val);
            p = p.next;
        }
        System.out.println(sb.toString());
    }
}
