package cn.celess.medium.T1488;

import cn.celess.utils.*;

import java.util.*;

public class AvoidFloodInTheCity {

    //@lc:start
    class Solution {
        public int[] avoidFlood(int[] rains) {
            if (rains.length == 1) {
                return new int[]{-1};
            }
            int[] res = new int[rains.length];
            Arrays.fill(res, -1);
            List<Integer> arrays = new ArrayList<>();
            int available = 0;


            Map<Integer, Integer> maps = new HashMap<>();
            for (int rain : rains) {
                if (rain == 0) {
                    available++;
                    continue;
                }
                maps.put(rain, maps.getOrDefault(rain, 0) + 1);
            }

            int needSunnyDayCount = 0;
            maps.forEach((integer, integer2) -> {
                if (integer2 == 1) {
                    maps.remove(integer);
                } else {
                    maps.put(integer, integer2 - 1);
                }
            });
            needSunnyDayCount = maps.values().stream().reduce(0, Integer::sum);


            if (needSunnyDayCount > available) return new int[]{};

            for (int i = 0; i < rains.length; i++) {
                int rain = rains[i];

                if (rain == 0 && arrays.size() > 0) {
                    res[i] = 0;
                    continue;
                }


                if (arrays.contains(rain)) {
                    if (available == 0) {
                        return new int[]{};
                    }
                    arrays.removeIf(integer -> integer == rain);
                    for (int i1 = 0; i1 < res.length && available > 0; i1++) {
                        if (res[i1] == 0) {
                            res[i1] = rain;
                            available--;
                            break;
                        }
                    }
                    continue;
                } else {
                    for (int i1 = 0; i1 < res.length && available > 0; i1++) {
                        if (res[i1] == 0) {
                            res[i1] = arrays.get(0);
                            arrays.remove(0);
                            available--;
                            break;
                        }
                    }
                }
                if (arrays.size() == 0 || !arrays.contains(rain)) {
                    arrays.add(rain);
                }
            }

            for (int i1 = 0; i1 < res.length && available > 0; i1++) {
                if (res[i1] == 0) {
                    res[i1] = 1;
                    available--;
                }
            }
            return res;
        }
    }
    //@lc:end


    public static void main(String[] args) {
        Solution solution = new AvoidFloodInTheCity().new Solution();
        Assert assertion = Assert.getInstance();
        assertion.print(1, 2, 0, 0, 2, 1).expect(Arrays.toString(new int[]{-1, -1, 2, 1, -1, -1})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
        assertion.print(1).expect(Arrays.toString(new int[]{-1})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1})));
        assertion.print(1, 2, 0, 1, 2).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 2, 0, 1, 2})));
        assertion.print(1, 2, 1, 2).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 2, 1, 2})));
        assertion.print(69, 0, 0, 0, 69).expect(Arrays.toString(new int[]{-1, 69, 1, 1, -1})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{69, 0, 0, 0, 69})));
        assertion.print(10, 20, 20).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{10, 20, 20})));
        assertion.print(0, 1, 1).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{0, 1, 1})));
        assertion.print(1, 1, 0).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 1, 0})));
        assertion.print(1, 1, 0, 0, 0, 0, 0).expect(Arrays.toString(new int[]{})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 1, 0, 0, 0, 0, 0})));
        assertion.print(1, 0, 2, 0, 2, 1).expect(Arrays.toString(new int[]{-1, 1, -1, 2, -1, -1})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{1, 0, 2, 0, 2, 1})));
        assertion.print(3, 5, 4, 0, 1, 0, 1, 5, 2, 8, 9).expect(Arrays.toString(new int[]{-1, -1, -1, 5, -1, 1, -1, -1, -1, -1, -1})).actual(() -> Arrays.toString(solution.avoidFlood(new int[]{3, 5, 4, 0, 1, 0, 1, 5, 2, 8, 9})));
    }
}
