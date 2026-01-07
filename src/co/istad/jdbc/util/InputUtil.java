package co.istad.jdbc.util;

import co.istad.jdbc.view.View;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputUtil {

    private static Scanner scanner = new Scanner(System.in);

    public static String getText(String label) {
        View.print(label + "-> ", false);
        return scanner.nextLine();
    }

    public static BigDecimal getMoney(String label) {
        do {
            View.print(label + "-> ", false);
            try {
                return BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));
            } catch (NumberFormatException e) {
                View.print(e.getMessage(), true);
            }
        } while(true);
    }

    public static Integer getInteger(String label) {
        do {
            View.print(label + "-> ", false);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                View.print(e.getMessage(), true);
            }
        } while(true);
    }

    public static Double getDouble(String label) {
        do {
            View.print(label + "-> ", false);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                View.print(e.getMessage(), true);
            }
        } while(true);
    }
}
