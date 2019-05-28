package com.paypay.app;

public class TestApplication {

    public static void main(String[] args) {
        IQueue<Integer> q = ImmutableQueue.getEmptyQueue();
        try{
            System.out.println(q.isEmpty());
            q = q.enQueue(1);
            printQueue(q);
            q = q.enQueue(2);
            printQueue(q);
            q = q.enQueue(null);
            printQueue(q);
            q = q.enQueue(3);
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            q = q.deQueue();
            printQueue(q);
            System.out.println("Is queue empty ? " + q.isEmpty());
            q = q.deQueue();
            System.out.println("Is queue empty ? " + q.isEmpty());
        }
        catch(Exception e){
            System.out.println("something went wrong: " + e.getMessage());
        }
    }

    private static void printQueue(IQueue<Integer> q) {
        while(q != null && !q.isEmpty()){
            System.out.print(q.head() + " -> ");
            q = q.deQueue();
        }
        System.out.println();
    }
}
