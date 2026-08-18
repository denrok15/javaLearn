//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Queue<Task> queue = new ArrayDeque<>();

    queue.offer(new Task(1L, Priority.LOW));
    queue.offer(new Task(2L, Priority.HIGH));
    queue.offer(new Task(3L, Priority.NORMAL));

    while (!queue.isEmpty()) {
        System.out.println(queue.poll());;

    }
}
