import support.Problem;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        Class[] problemClasses = new Class[] { Problem7.class, Problem6.class, Problem5.class, Problem4.class,
                Problem3.class, Problem2.class, Problem1.class };

        for (Class problemClass : problemClasses) {
            try {
                Problem problem = (Problem) problemClass.newInstance();
                Pair<Long, Long> answer = problem.solve();
                System.out.println(problem.getClass().getSimpleName() + ": " + answer.getKey() + " in " + answer.getValue() + " ms");
            } catch (Exception e) {

            }
        }
    }
}
