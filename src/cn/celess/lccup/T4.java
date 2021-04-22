package cn.celess.lccup;

import cn.celess.utils.Assert;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author : xiaohai
 * @date : 2021/04/10 14:52
 * @desc :
 */
public class T4 {

    class Solution {
        public int maxGroupNumber(int[] tiles) {
            int result = 0;
            List<Integer> list = new ArrayList<>();
            for (int tile : tiles) {
                list.add(tile);
            }

            list.sort(Comparator.comparingInt(l -> l));


            List<Integer> collect = new ArrayList<>();

            while (collect.size() == 0) {
                collect.addAll(list.stream().distinct().limit(3).collect(Collectors.toList()));
                if (collect.size() != 3) {
                    collect.clear();
                    System.out.println(list.stream().collect(Collectors.groupingBy(Integer::intValue)).values().stream().collect(Collectors.toList()));
                    //                    collect.addAll();
                    break;
                }
                System.out.println("--->" + collect);

                list.removeIf(integer -> {
                    boolean contains = collect.contains(integer);
                    collect.remove(integer);
                    return contains;
                });
                if (collect.size() == 0) {
                    result++;
                }
                System.out.println(list);
            }
            System.out.println("===" + result);
            return result;
        }
    }


    public static void main(String[] args) {
        Assert assertion = Assert.getInstance();

        Solution solution = new T4().new Solution();

        solution.maxGroupNumber(new int[]{2, 2, 2, 2, 2  , 3, 4, 1, 3});

    }
}
