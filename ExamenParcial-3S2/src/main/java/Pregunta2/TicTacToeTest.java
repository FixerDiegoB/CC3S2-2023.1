package Pregunta2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TicTacToeTest {
    TicTacToe ticTacToe;
    @BeforeEach
    public void setUp() {
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

    @Test
    public void juegaXPrimero() {
        Assertions.assertEquals('X', ticTacToe.proximoJugador());
    }

    @Test
    public void juegaODespuesDeX() {
        ticTacToe.jugar(2, 2);
        Assertions.assertEquals('O', ticTacToe.proximoJugador());
    }

    @Test
    public void noHayGanador() {
        Assertions.assertEquals(' ', ticTacToe.obtenerGanador());
    }

    @Test
    public void ganadorPorLineaHorizontal() {
        ticTacToe.jugar(1, 1);
        ticTacToe.jugar(2, 1);
        ticTacToe.jugar(1, 2);
        ticTacToe.jugar(2, 2);
        ticTacToe.jugar(1, 3);
        Assertions.assertEquals('X', ticTacToe.obtenerGanador());
    }

    @Test
    public void ganadorPorLineaVertical() {
        ticTacToe.jugar(1, 1);
        ticTacToe.jugar(1, 2);
        ticTacToe.jugar(2, 1);
        ticTacToe.jugar(2, 2);
        ticTacToe.jugar(3, 1);
        Assertions.assertEquals('X', ticTacToe.obtenerGanador());
    }

    @Test
    public void ganadorPorPrimeraLineaDiagonal() {
        ticTacToe.jugar(1, 1);
        ticTacToe.jugar(1, 2);
        ticTacToe.jugar(2, 2);
        ticTacToe.jugar(2, 1);
        ticTacToe.jugar(3, 3);
        Assertions.assertEquals('X', ticTacToe.obtenerGanador());
    }

    @Test
    public void ganadorPorSegundaLineaDiagonal() {
        ticTacToe.jugar(1, 3);
        ticTacToe.jugar(1, 2);
        ticTacToe.jugar(2, 2);
        ticTacToe.jugar(2, 1);
        ticTacToe.jugar(3, 1);
        Assertions.assertEquals('X', ticTacToe.obtenerGanador());
    }

    @Test
    public void empate(){
        ticTacToe.jugar(1, 1);
        ticTacToe.jugar(1, 2);
        ticTacToe.jugar(1, 3);
        ticTacToe.jugar(2, 1);
        ticTacToe.jugar(2, 3);
        ticTacToe.jugar(2, 2);
        ticTacToe.jugar(3, 1);
        ticTacToe.jugar(3, 3);
        ticTacToe.jugar(3, 2);
        Assertions.assertTrue(ticTacToe.hayEmpate());
    }
}
