package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/electronics-shop/problem
 */
@KebronPractice(regDate = "2019-07-27 23:53")
public class ElectronicsShop extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"10 2 3", "3 1", "5 2 8"},
            {"5 1 1", "4", "5"},
    };

    public ElectronicsShop() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int b = Integer.valueOf(input.get(0)[0]);
        final int[] keyboards = Arrays
                .stream(input.get(1))
                .mapToInt(Integer::valueOf)
                .toArray();
        final int[] drives = Arrays
                .stream(input.get(2))
                .mapToInt(Integer::valueOf)
                .toArray();

        return getMoneySpent(keyboards, drives, b);
    }

    /*
     * Complete the getMoneySpent function below.
     */
    private static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */

        int cost = -1;

        for (final int keyboard : keyboards) {
            for (final int drive : drives) {
                final int total = keyboard + drive;

                if (total == b) {
                    return b;
                }

                if (total > b)
                    continue;

                if (total > cost)
                    cost = total;
            }
        }

        return cost;
    }
}
