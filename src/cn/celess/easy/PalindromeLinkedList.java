package cn.celess.easy;

import cn.celess.utils.*;
import cn.celess.utils.ListNodeUtil.*;

import java.util.ArrayDeque;
import java.util.Deque;


public class PalindromeLinkedList {

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
        /**
         * 方法三
         * 双向队列
         *
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            Deque<Integer> deque = new ArrayDeque<>();
            ListNode node = head;
            while (node != null) {
                deque.addLast(node.val);
                node = node.next;
            }

            while (deque.size() > 1) {
                if (!deque.pollFirst().equals(deque.pollLast())) {
                    return false;
                }
            }
            return true;
        }

        /**
         * 方法二
         * 快慢指针
         *
         * @param head
         * @return
         */
        public boolean isPalindrome_2(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }
            ListNode slow = head, fast = head;
            ListNode pre = head, prepre = null;
            while (fast != null && fast.next != null) {
                pre = slow;
                slow = slow.next;
                fast = fast.next.next;
                pre.next = prepre;
                prepre = pre;
            }
            if (fast != null) {
                slow = slow.next;
            }
            while (pre != null && slow != null) {
                if (pre.val != slow.val) {
                    return false;
                }
                pre = pre.next;
                slow = slow.next;
            }

            return true;
        }

        /**
         * 方法一
         * 反转 双指针判定
         *
         * @param head
         * @return
         */
        public boolean isPalindrome_1(ListNode head) {
            ListNode middle = head;
            ListNode begin = head;
            int len = 0;
            while (middle.next != null) {
                len++;
                middle = middle.next;
            }
            middle = head;
            for (int i = 0; i < Math.ceil(len / 2.0); i++) {
                middle = middle.next;
            }
            // 反转
            middle = reverseList(middle);
            ListNode node = middle;

            while (begin != middle && node != null) {
                if (begin.val != node.val) {
                    return false;
                }
                begin = begin.next;
                node = node.next;
            }
            return true;
        }

        /**
         * 反转链表
         *
         * @param head
         * @return
         */
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode node = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return node;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.expect(false).actual(solution.isPalindrome(ListNodeUtil.createNodeList(1, 2, 3, 1)));
        assertion.expect(true).actual(solution.isPalindrome(ListNodeUtil.createNodeList(1, 2, 2, 1)));
        assertion.expect(true).actual(solution.isPalindrome(ListNodeUtil.createNodeList(1, 2, 3, 2, 1)));
        assertion.expect(false).actual(solution.isPalindrome(ListNodeUtil.createNodeList(1, 2, 3, 1, 1, 1, 1, 1, 1, 1)));
        assertion.expect(true).actual(solution.isPalindrome(ListNodeUtil.createNodeList(1)));
    }
}
