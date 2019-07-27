package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 */
@KebronPractice(regDate = "2019-07-27 23:40")
public class CountingValleys extends HackerRankPractice {

    private static final String[][] inputs = {
            // n k, bill, b
            {"8", "UDDDUDUU"},
            {"12", "DDUUDDUDUUUD"},
    };

    public CountingValleys() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int n = Integer.valueOf(input.get(0)[0]);
        final String s = input.get(1)[0];

        return countingValleys(n, s);
    }

    // Complete the countingValleys function below.
    private static int countingValleys(int n, String s) {

        final char upAction = 'U';
        final char downAction = 'D';

        int seaLevel = 0;
        boolean onValley = false;
        int valleyCount = 0;

        for(int i = 0; i < n; i++) {
            final char action = s.charAt(i);
            if(action == upAction) {
                seaLevel++;
            } else if(action == downAction) {
                seaLevel--;
            }

            if(!onValley) {
                if(seaLevel < 0) {
                    valleyCount++;
                    onValley = true;
                }
            } else {
                if(seaLevel >= 0) {
                    onValley = false;
                }
            }
        }

        return valleyCount;
    }
}
