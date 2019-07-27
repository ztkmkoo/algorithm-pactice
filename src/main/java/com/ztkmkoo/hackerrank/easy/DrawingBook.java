package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/drawing-book/problem
 */
@KebronPractice(regDate = "2019-07-27 23:38")
public class DrawingBook extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"6", "2"},
            {"5", "4"},
    };


    public DrawingBook() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int n = Integer.valueOf(input.get(0)[0]);
        final int p = Integer.valueOf(input.get(1)[0]);

        return pageCount(n, p);
    }

    /*
     * Complete the pageCount function below.
     */
    private static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */

        final int front = n / 2;
        final int pPage = p / 2;

        final int back = front - pPage;

        return front >= back ? back : front;
    }
}
