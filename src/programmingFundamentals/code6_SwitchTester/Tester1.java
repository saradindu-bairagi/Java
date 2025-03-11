package code6_SwitchTester;

public class Tester1 {
    public static void main(String[] args) {
        char choice = 'u';
        switch (choice) {
            // Each vowel checked as a separate case blocks
            case 'a':
                System.out.println("It's a vowel!");
                break;
            case 'e':
                System.out.println("It's a vowel!");
                break;
            case 'i':
                System.out.println("It's a vowel!");
                break;
            case 'o':
                System.out.println("It's a vowel!");
                break;
            case 'u':
                System.out.println("It's a vowel!");
                break;
            // If none of the above cases match, then default case
            default:
                System.out.println("It's not a vowel");
        }
    }

}
