package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public int askNumber () {
        int answer;

        while (true) {
            try {
                answer = scanner.nextInt();
                return answer;
            } catch (InputMismatchException e) {
                System.out.print("ERROR: Please enter a digit: ");
            } finally {
                scanner.nextLine(); //buffer \n
            }
        }
    }

    public void showFinalResult(int[] config) {
        for (int i = 0; i < config.length; i++) {
            if (i < (config.length - 1)) {
                System.out.print("|" + config[i]);
            } else {
                System.out.print("|" + config[i] + "|");
            }
        }

        System.out.println();
        System.out.println();
        for (int row = 0; row < config.length; row++) {
            for (int columnIndex = 0; columnIndex < config.length; columnIndex++) {
                if (columnIndex == config[row]) {
                    System.out.print("|x");
                } else {
                    System.out.print("| ");
                }
            }
            System.out.println("|");
        }
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showQuestion(String question) {
        System.out.print(question);
    }
}
