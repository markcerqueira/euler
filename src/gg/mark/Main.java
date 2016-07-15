package gg.mark;

import gg.mark.problems.*;
import gg.mark.support.Problem;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        Class[] problemClasses = new Class[] { Problem3.class, Problem2.class, Problem1.class };

        for (Class problemClass : problemClasses) {
            try {
                Problem problem = (Problem) problemClass.newInstance();
                Pair<Long, Long> answer = problem.solve();
                System.out.println(problem.getClass().getSimpleName() + ": " + answer.getKey() + " in " + answer.getValue() + " seconds");
            } catch (Exception e) {

            }
        }
    }
}
