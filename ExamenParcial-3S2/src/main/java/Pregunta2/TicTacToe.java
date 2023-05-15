package Pregunta2;

public class TicTacToe {
    int[][] tablero = new int[3][3];
    char actualJugador = 'X';

    public void jugar(int x, int y) {
        validarLimitesTablero(x, y);
        validarLugarOcupado(x, y);
        marcarCasilla(x, y);
        if (obtenerGanador() != ' ') {
            System.out.println("El ganador es " + actualJugador);
            return;
        }
        else if (hayEmpate()) {
            System.out.println("Hay empate");
            return;
        }
        cambiarTurno();
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
        if (actualJugador == 'X')
            tablero[x - 1][y - 1] = 1;
        else
            tablero[x - 1][y - 1] = 2;
    }
    private  void cambiarTurno() {
        if (actualJugador == 'X')
            actualJugador = 'O';
        else
            actualJugador = 'X';
    }
    public char proximoJugador() {
        return actualJugador;
    }
    public char obtenerGanador() {
        if (hayGanadorPorLineaHorizontal() || hayGanadorPorLineaVertical() ||
                hayGanadorPorPrimeraLineaDiagonal() || hayGanadorPorSegundaLineaDiagonal())
            return actualJugador;
        return ' ';
    }
    private boolean hayGanadorPorLineaHorizontal() {
        for (int i = 0; i < 3; i++) {
            int valor = tablero[i][0];
            if (valor != 0 && tablero[i][1] == valor && tablero[i][2] == valor)
                return true;
        }
        return false;
    }
    private boolean hayGanadorPorLineaVertical() {
        for (int i = 0; i < 3; i++) {
            int valor = tablero[0][i];
            if (valor != 0 && tablero[1][i] == valor && tablero[2][i] == valor)
                return true;
        }
        return false;
    }
    private boolean hayGanadorPorPrimeraLineaDiagonal() {
        int valor = tablero[0][0];
        for (int i = 1; i < 3; i++) {
            if (tablero[i][i] != valor)
                return false;
        }
        return valor != 0;
    }
    private boolean hayGanadorPorSegundaLineaDiagonal() {
        int valor = tablero[0][2];
        for (int i = 1; i < 3; i++) {
            if (tablero[i][2 - i] != valor)
                return false;
        }
        return valor != 0;
    }
    public boolean hayEmpate() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j< 3; j++)
                if (tablero[i][j] == 0)
                    return false;
        return obtenerGanador() == ' ';
    }
}
