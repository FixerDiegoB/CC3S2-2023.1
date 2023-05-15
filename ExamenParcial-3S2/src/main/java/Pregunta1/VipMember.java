package Pregunta1;

public class VipMember extends Organizer{
    public VipMember(String nombre) {
        super(nombre);
    }

    @Override
    public void joinTournament() {
        System.out.println("Vip member " + this.getNombre() + " se une al torneo.");
    }

    @Override
    public void organizeTournament() {
        System.out.println("Vip member " + this.getNombre() + " organiza un torneo.");
    }
}
