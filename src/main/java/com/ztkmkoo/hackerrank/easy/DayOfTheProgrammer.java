package com.ztkmkoo.hackerrank.easy;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/day-of-the-programmer/problem?h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 */
@KebronPractice(regDate = "2019-07-27 22:47")
public class DayOfTheProgrammer extends HackerRankPractice {

    private static final String[][] inputs = {
            // year
            {"2017"},
            {"2016"},
            {"1800"},
    };

    public DayOfTheProgrammer() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int year = Integer.valueOf(input.get(0)[0]);
        return dayOfProgrammer(year);
    }

    // Complete the dayOfProgrammer function below.
    private static String dayOfProgrammer(int year) {

        if(year == 1918)
            return "26.09." + year;
        else if (year < 1918) {
            return (year % 4 == 0) ? "12.09." + year : "13.09." + year;
        } else {
            if(year % 400 == 0)
                return "12.09." + year;
            if (year % 100 == 0)
                return "13.09." + year;
            if(year % 4 == 0)
                return "12.09." + year;
            return "13.09." + year;
        }
    }
}
