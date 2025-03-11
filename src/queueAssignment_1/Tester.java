package queueAssignment_1;




class Tester {

    public static void main(String[] args) {

        Queue queue = new Queue(7);
        queue.enqueue(13983);
        queue.enqueue(10080);
        queue.enqueue(7113);
        queue.enqueue(2520);
        queue.enqueue(2500);

        Queue outputQueue = findEvenlyDivisibleNumbers(queue);

        System.out.println("Evenly divisible numbers");
        outputQueue.display();

    }

    public static Queue findEvenlyDivisibleNumbers(Queue queue) {
        // Create a result queue to hold numbers divisible by 1 to 10
        Queue resultQueue = new Queue(queue.getMaxSize());

        // Create a temporary queue to restore original contents if needed
        Queue tempQueue = new Queue(queue.getMaxSize());

        // Dequeue each element, check divisibility, and enqueue to result if valid
        while(!queue.isEmpty()) {
            int current = queue.dequeue();
            if(isDivisibleBy1To10(current)) {
                resultQueue.enqueue(current);
            }

        }

        // Return the queue containing numbers divisible by 1..10
        return resultQueue;
    }

    // Helper method to check if a number is divisible by all integers 1..10
    public static boolean isDivisibleBy1To10(int number) {
        for(int i = 1; i <= 10; i++) {
            if(number % i != 0) {
                return false;
            }
        }
        return true;
    }
}