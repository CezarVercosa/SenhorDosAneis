package personagens;

import classes.Classes;
import racas.Maia;

public class Saruman extends Personagem implements Maia {
    public Saruman() {
        super(2, 2, 9, 70, 1, Classes.MAGO, false,"S");
        setFala("Against the power of Mordor there can be no victory.");
    }

    @Override
    public Gandalf ressuscitar() {
        return null;
    }

    @Override
    public String falarFrase() {
        return getFala();
    }
}


