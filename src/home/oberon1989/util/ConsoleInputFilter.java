package home.oberon1989.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputFilter {

    public static int getIntValue() {
        boolean IsCorrectInput = false;
        int result = 0;
        while (!IsCorrectInput) {
            Scanner scanner = new Scanner(System.in);
            try {
                result = scanner.nextInt();
                IsCorrectInput = true;
            } catch (InputMismatchException exception) {
                System.out.println("Неверный ввод");
                IsCorrectInput = false;

            }
        }
        return result;
    }

    public static int getIntValue(int min, int max) {
        int result = 0;

        boolean IsCorrectInput = false;
        while (!IsCorrectInput) {
            result = getIntValue();
            if (!(result < min || result > max)) IsCorrectInput = true;
            else {
                System.out.println("Введенное число должно входить в диапазон " + min + " - " + max);
            }
        }
        return result;
    }
}
