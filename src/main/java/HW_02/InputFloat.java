import java.util.Scanner;

public class InputFloat {

    public static float getUserFloatInput() {
        float userInput = 0.0f;
        boolean validInput = false;

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Введите дробное число (типа float): ");
                userInput = scanner.nextFloat();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Ошибка: Введено некорректное значение. Пожалуйста, введите дробное число.");
                scanner.nextLine(); // Очистить буфер ввода
            }
        } while (!validInput);

        scanner.close();
        return userInput;
    }

    public static void main(String[] args) {
        float enteredFloat = getUserFloatInput();
        System.out.println("Вы ввели: " + enteredFloat);
    }
}
