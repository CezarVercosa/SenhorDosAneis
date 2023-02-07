package personagens;

import classes.Classes;
import racas.Monstro;

public class Goblim extends Personagem implements Monstro {
    public Goblim() {
        super(7, 4, 1, 20, 2, Classes.ARQUEIRO, false,"M");
        setGrunhido("Iiisshhhh");
    }
    @Override
    public String grunir() {
        return getGrunhido();
    }

}
