package personagens;

import classes.Classes;
import racas.Humano;
import racas.Monstro;

public class Urukhai extends Personagem implements Monstro, Humano {
    public Urukhai() {
        super(8, 6, 3, 45, 1, Classes.GUERREIRO, false,"U");
        setFala("Looks like meat's back on the menu boys!");
        setGrunhido("Uuurrrrrr");
    }

    @Override
    public void envelhecer() {
        setConstituicao(getConstituicao() - 2);
    }

    @Override
    public String falarFrase() {
        return getFala();
    }
    @Override
    public String grunir() {
        return getGrunhido();
    }

}
