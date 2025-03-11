package dsa;



public class StackAssignment1 {


    public static void main(String args[]) {

        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        calculateSum(stack);

        System.out.println("Updated stack");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        //Implement your code here
    }
}