package cn.celess.utils.test;

import cn.celess.utils.Assert;
import cn.celess.utils.ListNodeUtil;

/**
 * @author : xiaohai
 * @date : 2021/03/27 14:18
 * @desc :
 */
public class AssertTest {
    void testEqual() {
        Assert instance = Assert.getInstance();
        instance.assertEqual(ListNodeUtil.createNodeList(1, 2, 3, 4, 5, 6), ListNodeUtil.createNodeList(1, 2, 3, 4, 5, 6));
        instance.assertEqual(ListNodeUtil.createNodeList(1, 2, 3, 4, 5, 6), ListNodeUtil.createNodeList(1, 2, 3, 4, 5, 6, 7));
        instance.assertEqual(ListNodeUtil.createNodeList(), ListNodeUtil.createNodeList());
        instance.assertEqual(ListNodeUtil.createNodeList(), ListNodeUtil.createNodeList(1));
        instance.assertEqual(ListNodeUtil.createNodeList(2), ListNodeUtil.createNodeList(1));
        instance.assertEqual(ListNodeUtil.createNodeList(2, 1), ListNodeUtil.createNodeList(1, 2));
    }

    public static void main(String[] args) {
        new AssertTest().testEqual();
    }
}
