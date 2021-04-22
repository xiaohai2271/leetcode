package cn.celess.medium.T341;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;
/*
 * @lc app=leetcode.cn id=341 lang=java
 *
 * [341] 扁平化嵌套列表迭代器
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list. 
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested
    // list // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

// @lc code=start

/**
 * // This is the interface that allows for creating nested lists. // You should
 * not implement it, or speculate about its implementation public interface
 * NestedInteger {
 *
 * // @return true if this NestedInteger holds a single integer, rather than a
 * nested list. public boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a
 * single integer // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 *
 * // @return the nested list that this NestedInteger holds, if it holds a
 * nested list // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList(); }
 */

class NestedIterator implements Iterator<Integer> {

    private List<Integer> valList;
    private ListIterator<Integer> listIterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        valList = new ArrayList<>();
        dfs(nestedList);
        listIterator = this.valList.listIterator();
    }

    @Override
    public Integer next() {
        return listIterator.next();
    }

    @Override
    public boolean hasNext() {
        return listIterator.hasNext();
    }

    private void dfs(List<NestedInteger> list) {
        for (NestedInteger val : list) {
            if (val.isInteger())
                valList.add(val.getInteger());
            else
                dfs(val.getList());
        }
    }

}


/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
 * = i.next();
 */
// @lc code=end
