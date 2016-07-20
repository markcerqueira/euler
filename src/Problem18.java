import support.FileParser;
import support.Problem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mark on 7/19/16.
 *
 * https://projecteuler.net/problem=18
 */
public class Problem18 extends Problem {

    @Override
    public long solveProblem() throws Exception {
        // Because Problem 67 is the same problem (but with a larger dataset to work on), abstract the logic out to make
        // it reusable.
        return solveMaximumPathSum("/resources/18.txt");
    }

    public static long solveMaximumPathSum(String dataFilename) throws Exception {
        List<String> fileContent = FileParser.parseFile(dataFilename);

        List<Integer[]> pyramidRows = new ArrayList<>();

        // This block parses fileContent read from a String of space-separated numbers to a Integer[]. It pushes data
        // into the pyramidRows list with the longer rows on top (i.e. inverted pyramid).
        for (String line : fileContent) {
            String[] numbersAsStrings = line.split(" ");
            Integer[] numbersInt = new Integer[numbersAsStrings.length];
            for (int i = 0; i < numbersAsStrings.length; i++) {
                numbersInt[i] = Integer.parseInt(numbersAsStrings[i]);
            }
            pyramidRows.add(0, numbersInt);
        }

        // Dynamic programming! It's much, much faster than brute forcing and trying every possible path through the
        // triangle. We will break the problem down into smaller sets by looking at rows two at a time and creating
        // a single row that has the data we need to proceed. We will repeat this process until there is just one
        // row left (of size 1) that has our answer!
        while (pyramidRows.size() > 1) {
            // Longest row - this row is removed and will NOT be added back in again.
            Integer[] topRow = pyramidRows.remove(0);

            // Second longest row. We are going to take the information we need from topRow and put it in secondTopRow
            // and then push secondTopRow back into the pyramidRows list.
            Integer[] secondTopRow = pyramidRows.remove(0);

            // For each number (num) in secondTopRow, replace that number with the max of num + the number directly
            // above it in topRow (topRow[i]) or num + the number above and adjacent to that one in the topRow (topRow[i + 1]).
            for (int i = 0; i < secondTopRow.length; i++) {
                secondTopRow[i] = Math.max(secondTopRow[i] + topRow[i], secondTopRow[i] + topRow[i + 1]);
            }

            // secondTopRow has everything we need from topRow and secondTopRow so put it back into the list at the front
            // since it's now the longest row.
            pyramidRows.add(0, secondTopRow);
        }

        return pyramidRows.get(0)[0];
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTA3NA==";
    }
}
