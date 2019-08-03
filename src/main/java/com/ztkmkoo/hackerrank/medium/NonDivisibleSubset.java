package com.ztkmkoo.hackerrank.medium;

import com.ztkmkoo.hackerrank.HackerRankPractice;
import com.ztkmkoo.practice.KebronPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://www.hackerrank.com/challenges/non-divisible-subset/problem
 */
@KebronPractice(regDate = "2019-08-04 01:57")
public class NonDivisibleSubset extends HackerRankPractice {

    private static final String[][] inputs = {
            {"15 7", "278 576 496 727 410 124 338 149 209 702 282 718 771 575 436"},
            {"4 3", "1 7 2 4"},
            {"10 5", "770528134 663501748 384261537 800309024 103668401 538539662 385488901 101262949 557792122 46058493"},
            {"87 9", "61197933 56459859 319018589 271720536 358582070 849720202 481165658 675266245 541667092 615618805 129027583 755570852 437001718 86763458 791564527 163795318 981341013 516958303 592324531 611671866 157795445 718701842 773810960 72800260 281252802 404319361 757224413 682600363 606641861 986674925 176725535 256166138 827035972 124896145 37969090 136814243 274957936 980688849 293456190 141209943 346065260 550594766 132159011 491368651 3772767 131852400 633124868 148168785 339205816 705527969 551343090 824338597 241776176 286091680 919941899 728704934 37548669 513249437 888944501 239457900 977532594 140391002 260004333 911069927 586821751 113740158 370372870 97014913 28011421 489017248 492953261 73530695 27277034 570013262 81306939 519086053 993680429 599609256 639477062 677313848 950497430 672417749 266140123 601572332 273157042 777834449 123586826"},
            {"5 1", "1 2 3 4 5"},
            {"10 4", "1 2 3 4 5 6 7 8 9 10"},
    };

    public NonDivisibleSubset() {
        super(inputs);
    }

    @Override
    public Object run(List<String[]> input) {

        final int k = Integer.valueOf(input.get(0)[1]);
        final List<Integer> s = Stream
                .of(input.get(1))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return nonDivisibleSubset(k, s);
    }

    private static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        final int[] arr = calcList(k, s);
        int result = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0)
                continue;

            final Set<Integer> set = new HashSet<>();
            set.add(i);

            for (int j = 0; j < arr.length; j++) {
                if (i == j)
                    continue;
                if (arr[j] == 0)
                    continue;

                final int revJ = arr.length - j;
                final int b = revJ >= arr.length ? j : arr[j] > arr[revJ] ? j : revJ;

                boolean valid = true;
                for (final Integer integer : set) {
                    if (integer == b)
                        continue;
                    final int sum = integer + b;
                    if (sum % k == 0) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    set.add(b);
                }
            }

            int size = 0;
            for (final Integer integer : set) {
                final int count = arr[integer];
                if(integer == 0)
                    size++;
                else if(integer * 2 == 0 || integer * 2 == k)
                    size++;
                else
                    size += count;
            }

            if (size > result) {
                result = size;

            }
        }

        return result;
    }

    private static int[] calcList(final int k, final List<Integer> s) {
        final int[] arr = new int[k];

        for (final int v : s) {
            final int d = v % k;

            arr[d]++;
        }

        return arr;
    }
}
