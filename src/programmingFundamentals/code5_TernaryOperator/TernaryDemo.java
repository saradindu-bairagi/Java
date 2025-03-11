package code5_TernaryOperator;

public class TernaryDemo {
    public static void main(String[] args) {
        double orderPrice = 250;
        // Apply discounts based on order amount using ternary operator
        int discountPercent = (orderPrice >= 500) ? 10 : 5;
        System.out.println("Discount percent " + discountPercent);
        // Calculate the discounted price
        double finalAmount = orderPrice - (orderPrice * discountPercent / 100);
        System.out.println("Final Amount $" + finalAmount);
    }
}
