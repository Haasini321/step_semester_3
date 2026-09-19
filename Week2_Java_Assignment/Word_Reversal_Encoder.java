import java.util.Scanner;

public class Word_Reversal_Encoder {

    public static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < words.length; index++) {
            StringBuilder reversedWord =
                    new StringBuilder(words[index]);

            result.append(reversedWord.reverse());

            if (index < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter sentence: ");
            String sentence = scanner.nextLine();

            String result = reverseEachWord(sentence);

            System.out.println("Output: " + result);
        } catch (Exception exception) {
            System.out.println("Invalid input: " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
