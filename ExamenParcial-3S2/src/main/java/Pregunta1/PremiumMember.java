package Pregunta1;

public class PremiumMember extends Organizer {
    public PremiumMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println("Premium member " + this.getNombre() + " se une al torneo.");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Premium member " + this.getNombre() + " organiza un torneo.");
    }
}
