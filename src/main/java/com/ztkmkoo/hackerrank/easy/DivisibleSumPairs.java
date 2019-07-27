package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/divisible-sum-pairs/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
@KebronPractice(regDate = "2019-07-27 18:43")
public class DivisibleSumPairs extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, ar
            {"6 3", "1 3 2 6 1 2"},
    };

    public DivisibleSumPairs() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int n = Integer.valueOf(input.get(0)[0]);
        final int k = Integer.valueOf(input.get(0)[1]);

        final int[] ar = Arrays
                .stream(input.get(1))
                .mapToInt(value -> Integer.valueOf(value))
                .toArray();

        return divisibleSumPairs(n, k, ar);
    }

    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {

        int result = 0;
        for(int i = 0; i < n; i++) {
            final int a = ar[i];
            for(int j = i + 1; j < n; j++) {
                final int b = ar[j];
                final int sum = a + b;
                if(sum % k == 0)
                    result++;
            }
        }

        return result;
    }
}
