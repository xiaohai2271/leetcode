package cn.celess.utils;

/**
 * @author : xiaohai
 * @date : 2021/03/27 14:00
 * @desc :
 */
public class ListNodeUtil {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode createNodeList(int... o) {
        if (o.length == 0) return null;
        ListNode node = new ListNode(o[o.length - 1]);
        if (o.length == 1) return node;

        for (int i = o.length - 2; i >= 0; i--) {
            node = new ListNode(o[i], node);
        }
        return node;
    }

    public static void foreach(ListNode head) {
        if (head == null)
            return;
        ListNode p = head;
        StringBuilder sb = new StringBuilder();
        sb.append(p.val);
        p = p.next;
        while (p != null) {
            sb.append(" -> ");
            sb.append(p.val);
            p = p.next;
        }
        System.out.print(sb.toString());
    }

}
