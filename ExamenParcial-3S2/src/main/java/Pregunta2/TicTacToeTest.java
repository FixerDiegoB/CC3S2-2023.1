package Pregunta2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TicTacToeTest {
    static TicTacToe ticTacToe;
    @BeforeAll
    public static void setUp() {
        ticTacToe = new TicTacToe();
    }
    @Test
    public void limiteX() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ticTacToe.jugar(5, 2);
        });
    }

    @Test
    public void limiteY() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            ticTacToe.jugar(2, 5);
        });
    }

    @Test
    public void lugarOcupado() {
        ticTacToe.jugar(2, 2);
        Assertions.assertThrows(RuntimeException.class, () -> {
            ticTacToe.jugar(2, 2);
        });
    }
}
