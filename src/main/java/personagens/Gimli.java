package personagens;

import classes.Classes;
import racas.Anao;

public class Gimli extends Personagem implements Anao {

    private int bebado;

    public Gimli() {
        super(5, 10, 6, 60, 1, Classes.GUERREIRO, true,"I");
        setFala("Let them come. There is one Dwarf yet in Moria who still draws breath.");
        setBebado(0);

    }

    public int getBebado() {
        return bebado;
    }

    public void setBebado(int bebado) {
        this.bebado = bebado;
    }

    @Override
    public void beber() {
        if (getBebado() == 2) {
           setFala("What did I say? He can't hold his liquor!");
        }
        setBebado(getBebado() + 1);
    }

    @Override
    public String falarFrase() {
        return getFala();
    }
}
