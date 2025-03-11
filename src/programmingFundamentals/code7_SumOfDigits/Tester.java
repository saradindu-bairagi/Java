package code7_SumOfDigits;

class WhileTryout2 {
    public static void main(String[] args) {
        int inputNumber = 7865;
        int sumOfDigits = 0;
        int lastDigit = 0;
        while (inputNumber > 0) {
            // Extract the last digit of inputNumber
            lastDigit = inputNumber % 10;
            // Add lastDigit to the sumOfDigits
            sumOfDigits += lastDigit;
            // Remove the last digit from inputNumber
            inputNumber = inputNumber / 10;
        }
        System.out.println("Sum of digits of inputNumber is : " + sumOfDigits);
    }
}
