package Pregunta1;

public class FreeMember extends Member{
    public FreeMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println("Free member " + this.getNombre() + " se une al torneo.");
    }
}
