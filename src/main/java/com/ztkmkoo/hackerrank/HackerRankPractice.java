package com.ztkmkoo.hackerrank;

import com.ztkmkoo.practice.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class HackerRankPractice implements Practice {

    private final String[][] inputs;

    public HackerRankPractice(final String[][] inputs) {
        this.inputs = inputs;
    }

    public abstract Object run(final List<String[]> input);


    @Override
    public final void run() {

        if (inputs == null || inputs.length == 0) {
            run(null);
            return;
        }

        final int size = inputs.length;

        for (int i = 0; i < size; i++) {
            final String[] input = inputs[i];
            final List<String[]> params = splitString(input);

            final long start = System.currentTimeMillis();
            final Object r = run(params);
            final long cost = System.currentTimeMillis() - start;

            if (r != null)
                System.out.println(String.format("[TEST - %02d] %d ms: ", i + 1, cost) + r.toString());
            else
                System.out.println(String.format("[TEST - %02d] %d ms: ", i + 1, cost));
        }
    }

    protected List<String[]> splitString(String[] input) {

        if (input == null || input.length == 0)
            return Collections.emptyList();

        final List<String[]> result = new ArrayList<>(input.length);

        for (int i = 0; i < input.length; i++) {

            final String str = input[i];
            if (str == null || str.length() == 0) {
                result.add(new String[0]);
            } else {
                final String[] splits = str.split(" ");
                result.add(splits);
            }
        }

        return result;
    }
}
