import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== PASSWORD GENERATOR ===");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean upper = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean lower = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include numbers? (yes/no): ");
        boolean numbers = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Include symbols? (yes/no): ");
        boolean symbols = scanner.nextLine().equalsIgnoreCase("yes");

        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        PasswordGenerator generator = new PasswordGenerator(
                upper, lower, numbers, symbols, length
        );

        String password = generator.generatePassword();
        System.out.println("\nGenerated Password: " + password);

        String strength = PasswordStrengthChecker.checkStrength(password);
        System.out.println("Password Strength: " + strength);

        scanner.close();
    }
}
