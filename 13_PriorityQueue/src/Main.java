import emma.model.Person;
import emma.queue.PriorityQueue;
import emma.queue.Queue;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Person high = new Person("High", 0);
        Person low = new Person("low", 72);
        Person mid = new Person("mid", 53);
        Queue<Person> queueToRelease = new PriorityQueue<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o2.lockedDownDay - o1.lockedDownDay;
            }
        });
        queueToRelease.enQueue(high);
        queueToRelease.enQueue(mid);
        queueToRelease.enQueue(low);
        while (!queueToRelease.isEmpty()) {
            Person releaseOrder = queueToRelease.deQueue();
            System.out.println("This is " + releaseOrder.name + "->" + releaseOrder.lockedDownDay);
        }
    }
}
