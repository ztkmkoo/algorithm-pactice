package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/picking-numbers/problem
 */
@KebronPractice(regDate = "2019-08-04 01:26")
public class PickingNumbers extends HackerRankPractice {

    private static final String[][] inputs = {
            // size, s, d m
            {"6", "4 6 5 3 3 1"},
            {"6", "1 2 2 3 1 2"},
    };

    public PickingNumbers() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {
        List<Integer> a = Stream
                .of(input.get(1))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        return pickingNumbers(a);
    }

    private static int pickingNumbers(List<Integer> a) {
        // Write your code here

        final Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = 0; i < a.size(); i++) {
            final int mid = a.get(i);
            final int left = mid - 1;
            final int right = mid + 1;

            final boolean searchLeft =
                    !map.containsKey(left) || !map.containsKey(mid);
            final boolean searchRight =
                    !map.containsKey(right) || !map.containsKey(mid);

            if(!searchLeft && !searchRight)
                continue;

            int lCount = 0;
            int rCount = 0;
            for(int j = i; j < a.size(); j++) {
                final int e = a.get(j);

                if (searchLeft) {
                    if(e == mid || e == left) {
                        lCount++;
                    }
                }

                if (searchRight) {
                    if(e == mid || e == right) {
                        rCount++;
                    }
                }
            }

            final int count = lCount > rCount ? lCount : rCount;

            if(count > result) {
                result = count;
            }

            map.put(mid, count);

            if(searchLeft) {
                map.put(left, lCount);
            }

            if(searchRight) {
                map.put(right, rCount);
            }
        }

        return result;
    }
}
