import support.Problem;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        Class[] problemClasses = new Class[] { Problem10.class, Problem9.class,
                Problem8.class, Problem7.class, Problem6.class, Problem5.class,
                Problem4.class, Problem3.class, Problem2.class, Problem1.class };

        for (Class problemClass : problemClasses) {
            Problem problem = null;
            try {
                problem = (Problem) problemClass.newInstance();
            } catch (Exception e) {

            }

            Pair<Long, Long> answer = problem.solve();
            System.out.println(problem.getClass().getSimpleName() + ": " + answer.getKey() + " in " + answer.getValue() + " ms");
        }
    }
}
