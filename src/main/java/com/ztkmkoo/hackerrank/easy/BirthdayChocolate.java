package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/the-birthday-bar/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
@KebronPractice(regDate = "2019-07-27 17:26")
public class BirthdayChocolate extends HackerRankPractice {

    private static String[][] inputs = {
            // size, s, d m
            {"5", "1 2 1 3 2", "3 2"},
            {"6", "1 1 1 1 1 1", "3 2"},
            {"1", "4", "4 1"},
    };

    public BirthdayChocolate() {
        super(inputs);
    }

    @Override
    public Object run(final List<String[]> input) {

        final List<Integer> s = Arrays
                .asList(input.get(1))
                .stream()
                .map(str -> Integer.valueOf(str))
                .collect(Collectors.toList());

        final int d = Integer.valueOf(input.get(2)[0]);
        final int m = Integer.valueOf(input.get(2)[1]);

        return birthday(s, d, m);
    }

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {

        final int size = s.size();
        if(m > size)
            return 0;

        if (m == size) {

        }

        int result = 0;
        for(int i = 0; i < size - m + 1; i++) {

            int total = 0;
            for(int j = i; j < i + m; j++) {
                total += s.get(j);
                if(total > d)
                    break;
            }

            if(total == d)
                result++;
        }

        return result;
    }
}
