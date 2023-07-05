import Business.Board;
import View.View;

import static java.lang.Math.abs;

public class Controller {
    private static Controller controller;
    private View view;
    private Board board;
    private int totalResults;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void run() {
        this.view = new View();

        view.showQuestion("Enter a board size: ");
        this.board = new Board(view.askNumber());
        view.showMessage("");
        view.showMessage("");

        int k = 0;
        totalResults = 0;

        view.showMessage("Results:");
        view.showMessage("");
        nQueensBacktracking(board.getConfig(), k);
        view.showMessage("");
        view.showMessage("Number of possible results: " + totalResults);
    }


    private void nQueensBacktracking (int[] config, int k) {
        config[k] = preparePath();
        while (k < board.getSize()) {
            if (config[k] < config.length - 1) {
                config[k] = nextBrother(config[k]);
                if (k == (board.getSize() - 1)) { // Solution
                    if (sweetQueenPosition(config, k)) { // Feasible
                        processSolution(config); // Correct solution
                        break;
                    }
                }
                if (k < (board.getSize() - 1)) {
                    if (sweetQueenPosition(config, k)) { // Completable
                        nQueensBacktracking(config, (k + 1)); // Recursion
                    }
                }
            } else {
                break;
            }
        }
    }

    private void processSolution(int[] config) {
        totalResults++;
        view.showFinalResult(config);
        view.showMessage("");
    }

    private int preparePath() {
        return -1;
    }

    private int nextBrother(int configValue) {
        return configValue + 1;
    }



    private boolean sweetQueenPosition(int[] config, int k) {
        // ROW
        for (int i = 0; i < k; i++) {
            if (config[i] == config[k]) {
                return false;
            }
        }

        // DIAGONAL
        for (int i = 0; i < k; i++) {
            // if row difference == column difference, they are in diagonal
            if ( abs(i - k) == abs(config[i] - config[k]) ) {
                return false;
            }
        }

        return true;
    }
}
