import support.Factors;
import support.FileParser;
import support.Problem;

import java.util.*;

/**
 * Created by Mark on 7/20/16.
 *
 * https://projecteuler.net/problem=22
 */
public class Problem022 extends Problem {

    @Override
    public long solveProblem() throws Exception {
        List<String> fileContent = FileParser.parseFile("/resources/22.txt");

        // 22.txt contains all names on a single line so fileContent is a List with size = 1
        String[] names = fileContent.get(0).split(",");

        // Convert String[] to List<String>
        List<String> namesList = Arrays.asList(names);

        // And then sort that List<String>
        Collections.sort(namesList);

        long totalNamesScore = 0;
        for (int i = 0; i < namesList.size(); i++) {
            // Calculate individual name score
            int individualNameScore = 0;
            String name = namesList.get(i);
            for (int j = 0; j < name.length(); j++) {
                // Names include quotations. Just skip those.
                if (name.charAt(j) == '\"') {
                    continue;
                }

                // Subtracting 'A' and adding 1 gets us to the mapping where A -> 1, B -> 2, etc.
                individualNameScore += name.charAt(j) - 'A' + 1;
            }

            // Multiply by +1 to avoid off-by-one error (e.g. the first name score would be 0 if we didn't adjust by +1)
            totalNamesScore += (individualNameScore * (i + 1));
        }

        return totalNamesScore;
    }

    @Override
    public String base64EncodedAnswer() {
        return "ODcxMTk4Mjgy";
    }
}
