import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataEntryApp {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные (Фамилия Имя Отчество ДатаРождения НомерТелефона Пол): ");
            String input = scanner.nextLine();
            String[] userData = input.split(" ");

            if (userData.length != 6) {
                System.out.println("Ошибка: Неверное количество данных. Введите все требуемые данные.");
                return;
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDate = userData[3];
            long phoneNumber = Long.parseLong(userData[4]);
            char gender = userData[5].charAt(0);

            // Проверка формата данных
            if (!isValidDate(birthDate) || (gender != 'f' && gender != 'm')) {
                throw new InvalidDataFormatException("Ошибка: Неверный формат данных.");
            }

            // Создание или добавление в файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(lastName + ".txt", true))) {
                writer.write(lastName + firstName + middleName + birthDate + " " + phoneNumber + gender);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }

            System.out.println("Данные успешно записаны в файл " + lastName + ".txt");
        } catch (InvalidDataFormatException | NumberFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }

    private static boolean isValidDate(String date) {
        // Простая проверка формата даты, можно улучшить
        return date.matches("\\d{2}.\\d{2}.\\d{4}");
    }
}

class InvalidDataFormatException extends Exception {
    public InvalidDataFormatException(String message) {
        super(message);
    }
}
