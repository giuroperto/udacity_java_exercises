import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        try {
            File file = new File("tale_two_cities.txt");
            Scanner scanner = new Scanner(file);
            int wordCount = 0;

            while (scanner.hasNextLine()) {
                wordCount += scanner.nextLine().split(" ").length;
            }

            System.out.println(wordCount);
        } catch (Exception e) {
            System.out.println("Error while opening file.");
        }
    }
}
