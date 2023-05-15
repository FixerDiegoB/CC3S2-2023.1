package Pregunta2;

public class TicTacToe {
    int[][] tablero = new int[3][3];

    public void jugar(int x, int y) {
        validarLimitesTablero(x, y);
        validarLugarOcupado(x, y);
        marcarCasilla(x, y);
    }
    private void validarLimitesTablero(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X está fuera del tablero.");
        }
        if (y < 1 || y > 3) {
            throw new RuntimeException("Y está fuera del tablero.");
        }
    }
    private void validarLugarOcupado(int x, int y) {
        if (tablero[x - 1][y - 1] == 1) {
            throw new RuntimeException("Lugar ocupado.");
        }
    }
    private void marcarCasilla(int x, int y) {
        tablero[x - 1][y - 1] = 1;
    }

}
