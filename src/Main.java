import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

void main() {
    Queue<Task> queue = new ArrayDeque<>();

    queue.offer(new Task(1L, Priority.LOW));
    queue.offer(new Task(2L, Priority.HIGH));
    queue.offer(new Task(3L, Priority.NORMAL));

    System.out.println("Обычная очередь:");
    while (!queue.isEmpty()) {
        System.out.println(queue.poll());
    }

    Queue<Task> pq = new PriorityQueue<>(Comparator.comparing(Task::getPriority));

    pq.offer(new Task(1L, Priority.LOW));
    pq.offer(new Task(2L, Priority.HIGH));
    pq.offer(new Task(3L, Priority.NORMAL));

    System.out.println("Очередь с приоритетом:");
    while (!pq.isEmpty()) {
        System.out.println(pq.poll());
    }
}
