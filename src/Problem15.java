import support.Problem;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by Mark on 7/18/16.
 *
 * https://projecteuler.net/problem=15
 */
public class Problem15 extends Problem {

    private static final BigInteger GRID_DIMENSION = BigInteger.valueOf(20); // n
    private static final BigInteger DECISIONS = BigInteger.valueOf(40); // k

    /* private class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } */

    // Memoization for choose function
    public Map<String, Long> chooseResultMap = new HashMap<>();

    public long choose(long total, long choose){
        if(total < choose) {
            return 0;
        }
        if(choose == 0 || choose == total) {
            return 1;
        }

        long firstTerm;
        String firstKey = (total - 1) + "," + (choose - 1);
        if (chooseResultMap.containsKey(firstKey)) {
            firstTerm = chooseResultMap.get(firstKey);
        } else {
            firstTerm = choose(total-1,choose-1);
            chooseResultMap.put(firstKey, firstTerm);
        }

        long secondTerm;
        String secondKey = (total - 1) + "," + (choose);
        if (chooseResultMap.containsKey(secondKey)) {
            secondTerm = chooseResultMap.get(secondKey);
        } else {
            secondTerm = choose(total - 1, choose);
            chooseResultMap.put(secondKey, secondTerm);
        }

        return firstTerm + secondTerm;
    }

    @Override
    public long solveProblem() {
        return choose(40, 20);

        // This solution that iterates over all paths using a Stack is okay for grids that are around 10 wide/high,
        // but becomes too computational expensive as grid grows.
        /* Stack<Point> pointStack = new Stack<>();
        pointStack.add(new Point(0, 0));
        long routes = 0;
        while(!pointStack.empty()) {
            Point p = pointStack.pop();

            if (p.x == GRID_DIMENSION && p.y == GRID_DIMENSION) {
                routes++;
                continue;
            }

            if (p.y + 1 <= GRID_DIMENSION) {
                pointStack.push(new Point(p.x, p.y + 1));
            }

            if (p.x + 1 <= GRID_DIMENSION) {
                pointStack.push(new Point(p.x + 1, p.y));
            }
        }
        return routes; */
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTM3ODQ2NTI4ODIw";
    }
}
