import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VacancyLoader {
    public List<Vacancy> loadVacancies(Path file) {
        List<Vacancy> vacancies = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                vacancies.add(parseVacancy(line, lineNumber));
            }
        } catch (IOException e) {
            throw new VacancyParsingException("Не удалось прочитать файл: " + file, e);
        }

        return vacancies;
    }

    private Vacancy parseVacancy(String line, int lineNumber) {
        String[] parts = line.split("\\|", -1);
        if (parts.length != 3) {
            throw invalidLine(lineNumber, line, "ожидалось 3 поля");
        }

        try {
            int salary = Integer.parseInt(parts[1].trim());
            return new Vacancy(parts[0].trim(), salary, parts[2].trim());
        } catch (NumberFormatException e) {
            throw invalidLine(lineNumber, line, "salary не число", e);
        }
    }

    private VacancyParsingException invalidLine(int lineNumber, String line, String reason) {
        return new VacancyParsingException(
                "Некорректная строка " + lineNumber + ": " + line + " (" + reason + ")"
        );
    }

    private VacancyParsingException invalidLine(int lineNumber, String line, String reason, Throwable cause) {
        return new VacancyParsingException(
                "Некорректная строка " + lineNumber + ": " + line + " (" + reason + ")",
                cause
        );
    }
}
