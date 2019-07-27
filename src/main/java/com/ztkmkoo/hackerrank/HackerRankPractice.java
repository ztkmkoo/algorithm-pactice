package com.ztkmkoo.hackerrank;

import com.ztkmkoo.practice.Practice;

public abstract class HackerRankPractice implements Practice {

    private final String[][] inputs;

    public HackerRankPractice(final String[][] inputs) {
        this.inputs = inputs;
    }

    public abstract Object run(Object[] params);

    public abstract Object[] getPrams(final String[] input);


    @Override
    public final void run() {

        if (inputs.length == 0) {
            run(null);
            return;
        }

        for (int i = 0; i < inputs.length; i++) {
            final String[] input = inputs[i];
            final Object[] params = getPrams(input);
            run(params);
        }
    }
}
