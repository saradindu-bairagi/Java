package code6_SwitchTester;

public class Tester3 {

    public static void main(String[] args) {
        char choice = 'U';
        switch (choice) {
            // Each vowel is checked in a single case statement,
            // and the values are separated by comma
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
                System.out.println("It's a vowel!");
                break;
            default:
                System.out.println("It's a consonant!");
        }
    }

}
