package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
 */
@KebronPractice(regDate = "2019-07-28 00:11")
public class CatsAndAMouse extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"2", "1 2 3", "1 3 2"},
    };

    public CatsAndAMouse() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int size = Integer.valueOf(input.get(0)[0]);

        for (int i = 0; i < size; i++) {
            final String[] splits = input.get(i + 1);
            final int x = Integer.valueOf(splits[0]);
            final int y = Integer.valueOf(splits[1]);
            final int z = Integer.valueOf(splits[2]);
            final String result = catAndMouse(x, y, z);
            System.out.println(String.format("%d %d %d: %s", x, y, z, result));
        }

        return null;
    }

    // Complete the catAndMouse function below.
    private static String catAndMouse(int x, int y, int z) {

        final int diffA = Math.abs(z - x);
        final int diffB = Math.abs(z - y);

        final int diff = diffA - diffB;
        if(diff == 0)
            return "Mouse C";
        if(diff > 0)
            return "Cat B";
        return "Cat A";
    }

}
