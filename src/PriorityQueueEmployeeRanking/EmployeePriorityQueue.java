package PriorityQueueEmployeeRanking;

import java.util.*;

class Queue {
    private int front;
    private int rear;
    private int maxSize;
    private String[] arr;

    Queue(int maxSize) {
        this.front = 0;
        this.rear = -1;
        this.maxSize = maxSize;
        this.arr = new String[this.maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean enqueue(String data) {
        if (isFull()) {
            return false;
        } else {
            arr[++rear] = data;
            return true;
        }
    }

    public void display() {
        if (isEmpty())
            System.out.println("Queue is empty!");
        else {
            for (int index = front; index <= rear; index++) {
                System.out.println(arr[index]);
            }
        }
    }

    public boolean isEmpty() {
        return front > rear;
    }

    public String dequeue() {
        if (isEmpty()) {
            return null;
        } else {
            return arr[front++];
        }
    }

    public int getMaxSize() {
        return maxSize;
    }
}

public class EmployeePriorityQueue {
    public static Queue sortEmployees(Queue inStrQueue) {
        List<String> employeeList = new ArrayList<>();

        // Dequeue all elements into a list
        while (!inStrQueue.isEmpty()) {
            employeeList.add(inStrQueue.dequeue());
        }

        // Sorting logic based on rank and name
        employeeList.sort((a, b) -> {
            String[] empA = a.split(":");
            String[] empB = b.split(":");
            int rankA = Integer.parseInt(empA[1]);
            int rankB = Integer.parseInt(empB[1]);

            if (rankA == rankB) {
                return empA[0].compareTo(empB[0]); // Lexicographical order
            }
            return Integer.compare(rankA, rankB);
        });

        // Enqueue sorted elements into outStrQueue
        Queue outStrQueue = new Queue(employeeList.size());
        for (String emp : employeeList) {
            outStrQueue.enqueue(emp);
        }

        return outStrQueue;
    }

    public static void main(String[] args) {
        Queue inStrQueue = new Queue(4);
        inStrQueue.enqueue("John:3");
        inStrQueue.enqueue("Alice:2");
        inStrQueue.enqueue("Bob:2");
        inStrQueue.enqueue("Eve:1");

        Queue outStrQueue = sortEmployees(inStrQueue);
        outStrQueue.display();
    }
}
