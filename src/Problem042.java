import support.FileParser;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/22/16.
 *
 * https://projecteuler.net/problem=42
 */
public class Problem042 extends Problem {

    @Override
    public long solveProblem() throws Exception {
        List<String> fileContent = FileParser.parseFile("/resources/42.txt");
        String[] wordsArray = fileContent.get(0).split(",");

        Set<Integer> triangleNumbers = new LinkedHashSet<>();
        for (int n = 1; n < 1000; n++) {
            triangleNumbers.add((int) (.5 * n * (n + 1)));
        }

        long triangleWords = 0;
        for (int i = 0; i < wordsArray.length; i++) {
            int wordSum = 0;

            // Go from 1 to length() - 1 because our words include quotes at beginning and end
            for (int j = 1; j < wordsArray[i].length() - 1; j++) {
                // Subtracting 'A' and adding 1 gets us to the mapping where A -> 1, B -> 2, etc.
                wordSum += wordsArray[i].charAt(j) - 'A' + 1;
            }

            if (triangleNumbers.contains(wordSum)) {
                triangleWords++;
            }
        }


        return triangleWords;
    }

    @Override
    public String base64EncodedAnswer() {
        return "MTYy";
    }
}
