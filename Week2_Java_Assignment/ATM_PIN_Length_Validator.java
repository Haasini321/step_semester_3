import java.util.Scanner;

public class ATM_PIN_Length_Validator {

    public static void checkPinLength(String pin) {
        int pinLength = pin.length();

        if (pinLength != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter PIN: ");
            String pin = scanner.nextLine();

            checkPinLength(pin);
        } catch (Exception exception) {
            System.out.println("Invalid input: " + exception.getMessage());
        } finally {
            scanner.close();
        }
    }
}
