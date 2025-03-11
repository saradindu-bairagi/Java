package code6_SwitchTester;

public class Tester2 {

    public static void main(String[] args) {
        char choice = 'i';
        // Each vowel checked as a common case block
        switch (choice) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("It's a vowel!");
                break;
            default:
                System.out.println("It's not a vowel");
        }
    }

}
