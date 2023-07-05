import Business.Tablero;
import View.View;

import static java.lang.Math.abs;

public class Controller {
    private static Controller controller;
    private View view;
    private Tablero tablero;

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    public void run() {
        this.view = new View();

        int sizeValor = view.askNumber();
        this.tablero = new Tablero(sizeValor);

        int k = 0;

        view.showMessage("Resultados:");
        nQueensBacktracking(tablero.getConfig(), k);
    }


    private void nQueensBacktracking (int config[], int k) {
        config[k] = prepararRecorrido();
        while (k < tablero.getSize()) {
            if (config[k] < config.length - 1) {
                config[k] = siguienteHermano(config[k], k);
                if (k == (tablero.getSize() - 1)) { // Solucion
                    if (goodQueenPosition(config, k)) { // Factible
                        tratarSolucion(config); // En teoria esta es la solucion correcta
                        break;
                    }
                }
                if (k < (tablero.getSize() - 1)) {
                    if (goodQueenPosition(config, k)) { // Completable
                        nQueensBacktracking(config, (k + 1));
                    }
                }
            } else {
                break;
            }
        }
    }

    private void tratarSolucion(int[] config) {
        view.showFinalResult(config);
        view.showMessage("");
    }

    private int prepararRecorrido () {
        return -1;
    }

    private int siguienteHermano (int configValue, int k) {
        return configValue + 1;
    }



    private boolean goodQueenPosition(int[] config, int k) {
        int i = 0;
        boolean ok = true;

        // ROW
        while (i < k && ok) {
            if (config[i] == config[k]) {
                ok = false; // return false
            }

            i++;
        }

        // DIAGONAL
        i = 0;
        while (i < k && ok) {
            // si diferencia de filas == diferencia columnas
            if ( abs(i - k) == abs(config[i] - config[k]) ) {
                ok = false;
            }

            i++;
        }

        return ok;
    }
}
