import support.Problem;

public class Main {

    private static final boolean RUN_ONLY_FIRST_CLASS = false;

    public static void main(String[] args) {
        Class[] problemClasses = new Class[] {
                Problem35.class, Problem34.class, Problem33.class, Problem32.class, Problem31.class, Problem30.class,
                Problem29.class, Problem28.class, Problem27.class, Problem26.class, Problem25.class, Problem24.class,
                Problem23.class, Problem22.class, Problem21.class, Problem20.class, Problem19.class, Problem67.class,
                Problem18.class, Problem17.class, Problem16.class, Problem15.class, Problem14.class, Problem13.class,
                Problem12.class, Problem11.class, Problem10.class, Problem9.class, Problem8.class, Problem7.class,
                Problem6.class, Problem5.class, Problem4.class, Problem3.class, Problem2.class, Problem1.class
        };

        for (Class problemClass : problemClasses) {
            Problem problem = null;
            try {
                problem = (Problem) problemClass.newInstance();
            } catch (Exception e) {
                System.out.println(e);
            }

            problem.runAndLogOutput();

            if (RUN_ONLY_FIRST_CLASS) {
                break;
            }
        }
    }
}
