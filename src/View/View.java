package View;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    private Scanner scanner = new Scanner(System.in);

    public int askNumber () {
        int answer;

        while (true) {
            try {
                answer = scanner.nextInt();
                return answer;
            } catch (InputMismatchException e) { //QUALSEVOL COSA QUE NO SIGUI UN NOMBRE ENTRAREM DINS EL CATCH
                e.printStackTrace(); //mostra un error en vermell i va bé per debuggar.
                System.out.print("ERROR: Please enter a digit: ");
            } finally {
                scanner.nextLine(); //ens carreguem el \n
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
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
