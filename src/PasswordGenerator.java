import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

    private boolean useUpper;
    private boolean useLower;
    private boolean useNumbers;
    private boolean useSymbols;
    private int length;

    public PasswordGenerator(boolean useUpper, boolean useLower,
                             boolean useNumbers, boolean useSymbols, int length) {
        this.useUpper = useUpper;
        this.useLower = useLower;
        this.useNumbers = useNumbers;
        this.useSymbols = useSymbols;
        this.length = length;
    }

    public String generatePassword() {
        StringBuilder characterPool = new StringBuilder();

        if (useUpper) characterPool.append(UPPERCASE);
        if (useLower) characterPool.append(LOWERCASE);
        if (useNumbers) characterPool.append(NUMBERS);
        if (useSymbols) characterPool.append(SYMBOLS);

        if (characterPool.length() == 0) {
            return "No character type selected!";
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }
}
