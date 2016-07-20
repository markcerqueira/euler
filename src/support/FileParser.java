package support;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 7/20/16.
 */
public class FileParser {

    // Helper method to parse file specified in filename param and return list of lines
    public static List<String> parseFile(String filename) throws Exception {
        InputStream inputStream = FileParser.class.getResourceAsStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

        List<String> fileLines = new ArrayList<>();

        String text;
        while ((text = reader.readLine()) != null) {
            fileLines.add(text);
        }

        if (reader != null) {
            reader.close();
        }

        return fileLines;
    }

}
