public class Vacancy {
    private final String title;
    private final int salary;
    private final String city;

    public Vacancy(String title, int salary, String city) {
        this.title = title;
        this.salary = salary;
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public int getSalary() {
        return salary;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Vacancy{title='" + title + "', salary=" + salary + ", city='" + city + "'}";
    }
}
