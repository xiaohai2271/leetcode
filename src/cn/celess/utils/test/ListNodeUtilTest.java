package cn.celess.utils.test;

import cn.celess.utils.ListNodeUtil.ListNode;
import cn.celess.utils.ListNodeUtil;

/**
 * @author : xiaohai
 * @date : 2021/03/27 14:08
 * @desc :
 */
public class ListNodeUtilTest {
    void testCreate() {
        ListNode head = ListNodeUtil.createNodeList(1, 2, 3, 4, 5, 6);
        ListNodeUtil.foreach(head);
        head = ListNodeUtil.createNodeList(1, 2);
        ListNodeUtil.foreach(head);
        head = ListNodeUtil.createNodeList(1);
        ListNodeUtil.foreach(head);
        head = ListNodeUtil.createNodeList();
        ListNodeUtil.foreach(head);
    }


    public static void main(String[] args) {
        new ListNodeUtilTest().testCreate();
    }
}
