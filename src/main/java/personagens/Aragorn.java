package personagens;

import classes.Classes;
import racas.Humano;

public class Aragorn extends Personagem implements Humano {
    public Aragorn() {
        super(10, 7, 6, 60, 1, Classes.GUERREIRO, true,"A");
        setFala("A day may come when the courage of men fails… but it is not THIS day.");
    }
    @Override
    public String falarFrase() {
        return getFala();
    }
    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 1);
    }



}
