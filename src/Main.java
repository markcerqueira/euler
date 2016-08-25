import support.Problem;

import java.lang.reflect.Constructor;

public class Main {

    private static final String SINGLE_RUN_CLASS_NAME = "Problem097";

    private static final int MAX_PROBLEM_ID = 100;

    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName(SINGLE_RUN_CLASS_NAME);
            Constructor<?> ctor = clazz.getConstructor();
            Problem problem = (Problem) ctor.newInstance();
            problem.runAndLogOutput(false);

            if (SINGLE_RUN_CLASS_NAME != null || SINGLE_RUN_CLASS_NAME.length() < 2) {
                return;
            }
        } catch (Exception e) {
            System.out.println();
        }

        for (int i = MAX_PROBLEM_ID; i > 0; i--) {
            String problemClassName = "" + i;
            while (problemClassName.length() <= 2) {
                problemClassName = "0" + problemClassName;
            }

            Problem problem = null;
            try {
                Class<?> clazz = Class.forName("Problem" + problemClassName);
                Constructor<?> ctor = clazz.getConstructor();
                problem = (Problem) ctor.newInstance();
            } catch (Exception e) {

            }

            if (problem != null) {
                try {
                    problem.runAndLogOutput(true /* anonymize answers for README */);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}
