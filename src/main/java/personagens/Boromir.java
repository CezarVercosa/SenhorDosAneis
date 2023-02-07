package personagens;

import classes.Classes;
import racas.Humano;

public class Boromir extends Personagem implements Humano {

    public Boromir() {
        super(7, 6, 3, 40, 1, Classes.GUERREIRO, true,"B");
        setFala("One does not simply walk into Mordor.");
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 2);
    }

    @Override
    public String falarFrase() {
        return getFala();
    }
}
