import support.Problem;
import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
        Class[] problemClasses = new Class[] { Problem14.class,
                Problem13.class, Problem12.class, Problem11.class, Problem10.class, Problem9.class,
                Problem8.class, Problem7.class, Problem6.class, Problem5.class,
                Problem4.class, Problem3.class, Problem2.class, Problem1.class };

        for (Class problemClass : problemClasses) {
            Problem problem = null;
            try {
                problem = (Problem) problemClass.newInstance();
            } catch (Exception e) {
                System.out.println(e);
            }

            problem.runAndLogOutput();
        }
    }
}
