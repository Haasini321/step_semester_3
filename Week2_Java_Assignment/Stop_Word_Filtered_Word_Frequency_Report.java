import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Stop_Word_Filtered_Word_Frequency_Report {

    public static void printFilteredWordFrequency(String feedback) {

        String cleanedText = feedback
                .toLowerCase()
                .replace(".", "")
                .replace(",", "");

        String[] words = cleanedText.split("\\s+");

        String[] stopWords = {
                "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> wordFrequency =
                new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {

                if (wordFrequency.containsKey(word)) {
                    wordFrequency.put(
                            word,
                            wordFrequency.get(word) + 1
                    );
                } else {
                    wordFrequency.put(word, 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(wordFrequency.entrySet());

        entries.sort(
                Comparator.comparing(
                        Map.Entry<String, Integer>::getValue
                ).reversed()
        );

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                    entry.getKey() + ": " + entry.getValue()
            );
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter feedback: ");
            String feedback = scanner.nextLine();

            if (feedback.trim().isEmpty()) {
                throw new IllegalArgumentException(
                        "Feedback cannot be empty."
                );
            }

            printFilteredWordFrequency(feedback);

        } catch (Exception exception) {
            System.out.println(
                    "Invalid input: " + exception.getMessage()
            );
        } finally {
            scanner.close();
        }
    }
}
