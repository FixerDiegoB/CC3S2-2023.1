package Pregunta1;

interface TournamentParticipant {
    void joinTournament();
}

public abstract class Member implements TournamentParticipant {
    private final String nombre;

    public Member(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
