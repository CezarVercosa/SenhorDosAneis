package personagens;

import classes.Classes;
import racas.Elfo;

public class Legolas extends Personagem implements Elfo {
    public static final String FALAR_ELFICO = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";

    public Legolas() {
        super(5, 10, 6, 80, 2, Classes.ARQUEIRO, true,"L");
        setFala("They're taking the Hobbits to Isengard!");
    }

    @Override
    public String falarFraseElfica() {
        return FALAR_ELFICO;
    }

    @Override
    public String falarFrase() {
        return getFala();
    }

}
