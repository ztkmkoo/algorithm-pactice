package com.ztkmkoo.hackerrank.medium;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.math.BigInteger;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/extra-long-factorials/problem
 */
@KebronPractice(regDate = "2019-08-04 01:50")
public class ExtraLongFactorials extends HackerRankPractice {

    private static final String[][] inputs = {
            {"25"},
            {"45"},
    };

    public ExtraLongFactorials() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int n = Integer.valueOf(input.get(0)[0]);
        extraLongFactorials(n);
        return null;
    }

    // Complete the extraLongFactorials function below.
    private static void extraLongFactorials(int n) {

        BigInteger bigInteger = BigInteger.ONE;

        for (int i = 1; i <= n; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }

        System.out.println(bigInteger.toString());
    }
}
