package guru.qa;

import java.util.LinkedList;
import java.util.Queue;

public class CollectionQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("pr");
        queue.add("ad");
        queue.add("as");
        queue.add("cv");

        System.out.println(queue);
        queue.remove();
        System.out.println(queue);

        System.out.println(" ");
        findElement(queue);

        System.out.println("");
        removeElements(queue);

        System.out.println("");
        addedNewElement(queue);

    }

    public static void findElement(Queue<String> queue) {
        for (String value : queue){
            System.out.println(value);
        }
    }

    public static void removeElements(Queue<String> queue) {
        do {
            queue.remove();
            System.out.println(queue);
        } while (queue.size() != 0);

    }

    public static void addedNewElement(Queue<String> queue) {
        while (queue.size()<=10){
            queue.add("promis");
            System.out.println(queue);
        }
        System.out.println("The place is over");

    }

}
