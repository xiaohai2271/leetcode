package cn.celess.easy;

import cn.celess.utils.*;
import cn.celess.utils.ListNodeUtil;

public class ReverseLinkedList {

    //@lc:start

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        ListNode head = null;
        ListNode pHead = null;

        public ListNode reverseList_2(ListNode head) {
            if (head == null) return null;
            if (pHead == null) pHead = head;
            if (head.next != null) {
                reverseList_2(head.next).next = head;
            } else {
                this.head = head;
            }
            if (pHead == head) {
                head.next = null;
                return this.head;
            } else {
                return head;
            }
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }

        public ListNode reverseList_1(ListNode head) {
            if (head == null) return null;
            ListNode pre = null;
            ListNode node = head;
            ListNode next;
            while (node != null) {
                //记录当前节点的下一个节点
                next = node.next;
                //然后将当前节点指向pre
                node.next = pre;
                //pre和cur节点都前进一位
                pre = node;
                node = next;
            }
            return pre;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
        Assert assertion = Assert.getInstance();
        ListNode nodeList = ListNodeUtil.createNodeList(2, 1, 0, -1, -2, -3, -4, -5, -6, -7, -8, -9);
        ListNodeUtil.foreach(nodeList);
        System.out.println();
        nodeList = solution.reverseList(nodeList);
        System.out.println();
        ListNodeUtil.foreach(nodeList);


    }
}
