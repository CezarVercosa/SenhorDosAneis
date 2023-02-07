package personagens;

import classes.Classes;
import racas.Maia;

public class Gandalf extends Personagem implements Maia {
    public Gandalf() {
        super(2, 3, 10, 80, 1, Classes.MAGO, true,"G");
        setFala("A Wizard is never late, nor is he early. He arrives precisely when he means to.");
    }

    @Override
    public Gandalf ressuscitar() {
        if (getConstituicao() == 0) {
            new Gandalf();
        }
        return null;
    }

    @Override
    public String falarFrase() {
        return getFala();
    }

}
