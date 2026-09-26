import java.util.Scanner;

public class Library_ISBN_Normalizer_Validator {

    public static String normalizeCode(String raw) {
        String trimmedCode = raw.trim();

        if (trimmedCode.length() < 3) {
            return trimmedCode.toUpperCase();
        }

        String publisherCode =
                trimmedCode.substring(0, 3).toUpperCase();

        String remainingCode =
                trimmedCode.substring(3);

        return publisherCode + remainingCode;
    }

    public static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int index = 0; index < 3; index++) {
            if (!Character.isLetter(code.charAt(index))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int index = 3; index < code.length(); index++) {
            if (!Character.isDigit(code.charAt(index))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisherCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalogNumber = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(publisherCode);
        result.append("] YEAR: ");
        result.append(year);
        result.append(" | CATALOG: ");
        result.append(catalogNumber);

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter ISBN-style code: ");
            String rawCode = scanner.nextLine();

            String normalizedCode = normalizeCode(rawCode);

            String result = validateAndFormat(normalizedCode);

            System.out.println(result);
        } catch (Exception exception) {
            System.out.println("Invalid input: " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
