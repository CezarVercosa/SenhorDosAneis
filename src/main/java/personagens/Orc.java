package personagens;

import classes.Classes;
import racas.Monstro;

public class Orc extends Personagem implements Monstro {

    public Orc() {
        super(7, 4, 1, 30, 1, Classes.GUERREIRO, false,"O");
        setGrunhido("Arrrggghhh");
    }

    @Override
    public String grunir() {
        return getGrunhido();
    }
}
