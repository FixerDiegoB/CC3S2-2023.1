package Pregunta2;

public class TicTacToe {
    public void jugar(int x, int y) {
        if (x < 1 || x > 3) {
            throw new RuntimeException("X esta fuera del tablero.");
        }
    }
}
