import java.util.Scanner;

public class EmptyStringExceptionExample {

    public static void main(String[] args) {
        try {
            String input = getUserInput();
            if (input.isEmpty()) {
                throw new EmptyStringException("Пустые строки вводить нельзя!");
            }
            System.out.println("Вы ввели: " + input);
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        return scanner.nextLine();
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException(String message) {
        super(message);
    }
}
