package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/sock-merchant/problem
 */
@KebronPractice(regDate = "2019-07-27 23:21")
public class SockMerchant extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"9", "10 20 20 10 10 30 50 10 20"},
            {"10", "1 1 3 1 2 1 3 3 3 3"},
    };

    public SockMerchant() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int n = Integer.valueOf(input.get(0)[0]);
        final int[] ar = Arrays
                .stream(input.get(1))
                .mapToInt(Integer::valueOf)
                .toArray();

        return sockMerchant(n, ar);
    }

    // Complete the sockMerchant function below.
    private static int sockMerchant(int n, int[] ar) {

        int pair = 0;

        final Map<Integer, Integer> map = new HashMap<>();
        for (final int color : ar) {
            if (!map.containsKey(color)) {
                map.put(color, 0);
            }

            final int old = map.get(color);
            final int count = old + 1;
            map.put(color, count);

            if (count % 2 == 0)
                pair++;
        }

        return pair;
    }
}
