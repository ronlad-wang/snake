package snake.queue;

import java.util.Random;

public class queueTests {
    public static void main(String[] args) {
        queue testQueue = new queue();
        Random testRandom = new Random();
        for(int i = 0; i < testRandom.nextInt(4,9); i++) {
            testQueue.add(new int[]{testRandom.nextInt(0,100), testRandom.nextInt(0,100)});
        }

        printQueue(testQueue);

        testQueue.add(new int[]{testRandom.nextInt(0,100), testRandom.nextInt(0,100)});
        testQueue.add(new int[]{testRandom.nextInt(0,100), testRandom.nextInt(0,100)});
        System.out.println();
        printQueue(testQueue);

        testQueue.remove();
        testQueue.remove();
        System.out.println();
        printQueue(testQueue);
    }

    public static void printQueue(queue q) {
        Object[] tempList = q.toArray();
        for(int j = 0; j < q.size; j++) {
            int[] jarray = (int[]) tempList[j];
            System.out.println(jarray[0] + ", " + jarray[1]);
        }
    }
}
