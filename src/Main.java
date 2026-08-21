import java.util.ArrayDeque;
import java.util.Comparator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
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

        try {
            Path vacanciesFile = Files.createTempFile("vacancies", ".txt");
            Files.writeString(vacanciesFile, """
                    Java Developer|200000|Москва
                    QA Engineer|120000|Санкт-Петербург
                    """);

            VacancyLoader loader = new VacancyLoader();
            System.out.println("Вакансии из файла:");
            for (Vacancy vacancy : loader.loadVacancies(vacanciesFile)) {
                System.out.println(vacancy);
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать пример файла с вакансиями", e);
        }
    }
}
