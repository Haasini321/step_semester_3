import java.util.Scanner;

public class ExamHallSeatDuplicationChecker {

    // Method to check duplicate seat numbers
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;

        System.out.println("\nDuplicate Seat Numbers:");

        for (int firstIndex = 0; firstIndex < seatNumbers.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1;
                 secondIndex < seatNumbers.length;
                 secondIndex++) {

                if (seatNumbers[firstIndex] == seatNumbers[secondIndex]) {
                    System.out.println("Duplicate Seat Number Found: "
                            + seatNumbers[firstIndex]);

                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // Method to read seat numbers
    public static int[] readSeatNumbers(Scanner scanner, int numberOfStudents) {
        int[] seatNumbers = new int[numberOfStudents];

        for (int index = 0; index < numberOfStudents; index++) {
            System.out.print("Enter seat number for student "
                    + (index + 1) + ": ");

            seatNumbers[index] = scanner.nextInt();
        }

        return seatNumbers;
    }

    public static void main(String[] args) {
        final int NUMBER_OF_STUDENTS = 5;

        Scanner scanner = new Scanner(System.in);

        try {
            int[] seatNumbers =
                    readSeatNumbers(scanner, NUMBER_OF_STUDENTS);

            checkDuplicateSeats(seatNumbers);

        } catch (Exception exception) {
            System.out.println("Invalid input: "
                    + exception.getMessage());

        } finally {
            scanner.close();
        }
    }
}
