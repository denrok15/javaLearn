public class Task {
    private final long id;
    private final Priority priority;

    public Task(long id, Priority priority) {
        this.id = id;
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public Priority getPriority() {
        return priority;
    }


    // конструктор + геттеры
}