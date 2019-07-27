package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/bon-appetit/problem
 */
@KebronPractice(regDate = "2019-07-27 23:07")
public class BonAppetit extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"4 1", "3 10 2 9", "12"},
            {"4 1", "3 10 2 9", "7"},
    };

    public BonAppetit() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int k = Integer.valueOf(input.get(0)[1]);
        final List<Integer> bill = Arrays
                .stream(input.get(1))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        final int b = Integer.valueOf(input.get(2)[0]);

        bonAppetit(bill, k ,b);
        return null;
    }

    // Complete the bonAppetit function below.
    private static void bonAppetit(List<Integer> bill, int k, int b) {

        int share = 0;
        for(int i = 0; i < bill.size(); i++) {
            if(i == k)
                continue;
            share += bill.get(i);
        }

        final int actual = share / 2;
        if (b > actual) {
            System.out.println(b - actual);
        } else {
            System.out.println("Bon Appetit");
        }
    }
}
