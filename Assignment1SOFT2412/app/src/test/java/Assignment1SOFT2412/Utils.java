package Assignment1SOFT2412;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class Utils {

    /**
     * Reads the content of a file and returns it as a string.
     * @param filePath The path to the file to be read.
     * @return The content of the file as a string.
     * @throws IOException If there is an error reading the file.
     */
    public static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString().trim(); // trim to remove trailing newline
    }

    /**
     * Writes the given content to a file.
     * @param filePath The path to the file to be written.
     * @param content The content to write to the file.
     * @throws IOException If there is an error writing to the file.
     */
    public static void writeToFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }
}
