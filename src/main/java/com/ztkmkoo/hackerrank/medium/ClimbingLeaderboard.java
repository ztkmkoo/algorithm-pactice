package com.ztkmkoo.hackerrank.medium;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.*;

/**
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
 */
@KebronPractice(regDate = "2019-08-01 23:44")
public class ClimbingLeaderboard extends HackerRankPractice {

    private static final String[][] inputs = {
            {"7", "100 100 50 40 40 20 10", "4", "5 25 50 120"},
            {"6", "100 90 90 80 75 60", "5", "50 65 77 90 102"},
    };

    public ClimbingLeaderboard() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        int[] scores = Arrays.stream(input.get(1)).mapToInt(Integer::valueOf).toArray();
        int[] alice = Arrays.stream(input.get(3)).mapToInt(Integer::valueOf).toArray();

        return Arrays.toString(climbingLeaderboard(scores, alice));
    }

    // Complete the climbingLeaderboard function below.
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {

        final List<Integer> scoreList = new ArrayList<>();
        int index = -1;
        for (int i = 0; i < scores.length; i++) {
            final int score = scores[i];
            if (i != 0) {
                if(scoreList.get(index) == score)
                    continue;
            }

            scoreList.add(score);
            index++;
        }

        final int[] result = new int[alice.length];
        int rIndex = 0;

        for (final int aScore : alice) {
            while (index >= 0) {
                if (aScore >= scoreList.get(index))
                    index--;
                else {
                    result[rIndex++] = (index + 2);
                    break;
                }
            }
            if (index < 0)
                result[rIndex++] = 1;
        }

        return result;
    }
}
