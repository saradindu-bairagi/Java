//Problem Statement
//Implement a program to calculate the product of three positive integer values.
// However, if one of the integers is 7, consider only the values to the right of 7 for calculation.
// If 7 is the last integer, then display -1.
//
//Note: Only one of the three values can be 7.
package code3_Assignment_7_SelectionControlStructure;

public class Tester {
    public static int calculateProduct(int a, int b, int c) {
        int[] nums = {a, b, c};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 7) {
                if (i == nums.length - 1) {
                    return -1; // If 7 is the last number, return -1
                } else {
                    return nums[i + 1] * (i + 2 < nums.length ? nums[i + 2] : 1);
                }
            }
        }

        // If no 7 is found, return the product of all numbers
        return a * b * c;
    }

    public static void main(String[] args) {
        System.out.println(calculateProduct(1, 5, 3)); // Output: 15
        System.out.println(calculateProduct(3, 7, 8)); // Output: 8
        System.out.println(calculateProduct(7, 2, 9)); // Output: 18
        System.out.println(calculateProduct(2, 6, 7)); // Output: -1
    }
}