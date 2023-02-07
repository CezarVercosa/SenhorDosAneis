import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import exceptions.SauronDominaOMundoException;
import mapa.Mapa;
import org.junit.Assert;
import org.junit.Test;
import personagens.*;
import simulador.Simulador;

public class SimuladorTest {
    //Inicio Testes Obrigatorios
    @Test
    public void deveVencerSociedadeQuandoAragornELegolasBatalharemContraOrcEGoblim() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Aragorn aragorn = new Aragorn();
        Legolas legolas = new Legolas();
        Goblim goblim = new Goblim();
        Orc orc = new Orc();

        String resultadoEsperado = "| | | | |A| | | | |L|";

        mapa.inserirPersonagem(0, aragorn);
        mapa.inserirPersonagem(1, legolas);
        mapa.inserirPersonagem(9, goblim);
        mapa.inserirPersonagem(7, orc);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoInimigosDerrotaremMembrosDaSociedade() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Aragorn aragorn = new Aragorn();
        Gimli gimli = new Gimli();
        Urukhai urukhai = new Urukhai();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        mapa.inserirPersonagem(0, aragorn);
        mapa.inserirPersonagem(2, gimli);
        mapa.inserirPersonagem(7, urukhai);
        mapa.inserirPersonagem(8, orc);
        mapa.inserirPersonagem(9, goblim);
        simulador.simular();
    }
    @Test
    public void deveVencerSociedadeQuandoGandalfBatalharSozinhoContraSaruman() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Gandalf gandalf = new Gandalf();
        Saruman saruman = new Saruman();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        String resultadoEsperado = "| | | | | | | | | |G|";


        mapa.inserirPersonagem(0, gandalf);
        mapa.inserirPersonagem(9, saruman);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoLegolasBatalharSozinhoContraOrcEUrukhai() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Orc orc = new Orc();
        Urukhai urukhai = new Urukhai();
        Legolas legolas = new Legolas();

        mapa.inserirPersonagem(9, orc);
        mapa.inserirPersonagem(8, urukhai);
        mapa.inserirPersonagem(0, legolas);
        simulador.simular();
    }
    @Test(expected = SauronDominaOMundoException.class)
    public void deveLancarSauronDominaOMundoExceptionQuandoBoromirBatalharSozinhoContraUrukhai() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Urukhai urukhai = new Urukhai();
        Boromir boromir = new Boromir();

        mapa.inserirPersonagem(0, boromir);
        mapa.inserirPersonagem(9, urukhai);
        simulador.simular();
    }

    //Fim Testes Obrigatorios

    //Inicio Testes Metodos

    @Test
    public void falaDiferenteDoGimliQuandoFicarBebado() {
        Gimli gimli = new Gimli();

        String falaEsperada =  "What did I say? He can't hold his liquor!";
        gimli.beber();
        gimli.beber();
        gimli.beber();

        Assert.assertEquals(falaEsperada, gimli.getFala());

    }
    @Test
    public void inteligenciaDoGimli() {
        Gimli gimli = new Gimli();

        int resultadoEsperado = 6;

        Assert.assertEquals(resultadoEsperado, gimli.getInteligencia());
    }
    @Test
    public void agilidadeDeGimli() {
        Gimli gimli = new Gimli();

        int resultadoEsperado = 10;

        Assert.assertEquals(resultadoEsperado, gimli.getAgilidade());
    }
    @Test
    public void falaDeGimli() {
        Gimli gimli = new Gimli();

        String resultadoEsperado = "Let them come. There is one Dwarf yet in Moria who still draws breath.";

        Assert.assertEquals(resultadoEsperado, gimli.falarFrase());
    }
    @Test
    public void forcaDeGimli(){
        Gimli gimli = new Gimli();

        int resultadoEsperado = 5;

        Assert.assertEquals(resultadoEsperado, gimli.getForca());
    }
    @Test
    public void ressuscitarGandalf() {
        Gandalf gandalf = new Gandalf();
        gandalf.setConstituicao(0);
        Gandalf Gandalf2 = gandalf.ressuscitar();

        Assert.assertEquals(gandalf.ressuscitar(), Gandalf2);
    }
    @Test
    public void falaDoGandalf() {
        Gandalf gandalf = new Gandalf();

        String resultadoEsperado = "A Wizard is never late, nor is he early. He arrives precisely when he means to.";

        Assert.assertEquals(resultadoEsperado, gandalf.falarFrase());
    }
    @Test
    public void toStringGandalf(){
        Gandalf gandalf = new Gandalf();

        String resultadoEsperado = "G";

        Assert.assertEquals(resultadoEsperado, gandalf.toString());
    }
    @Test
    public void forcaDoGandalf() {
        Gandalf gandalf = new Gandalf();

        int resultadoEsperado = 2;

        Assert.assertEquals(resultadoEsperado, gandalf.getForca());
    }
    @Test
    public void agilidadeDoGandalf(){
        Gandalf gandalf = new Gandalf();

        int resultadoEsperado = 3;

        Assert.assertEquals(resultadoEsperado, gandalf.getAgilidade());
    }
    @Test
    public void naoDeveRessuscitarGandalf() {
        Gandalf gandalf = new Gandalf();

        gandalf.setConstituicao(2);

        Assert.assertNull(gandalf.ressuscitar());
    }
    @Test
    public void envelhecerBoromir() {
        Boromir boromir = new Boromir();
        boromir.envelhecer();
        int resultadoEsperado = 38;

        Assert.assertEquals(resultadoEsperado, boromir.getConstituicao());
    }
    @Test
    public void agilidadeDoBoromir() {
        Boromir boromir = new Boromir();

        int resultadoEsperado = 6;

        Assert.assertEquals(resultadoEsperado, boromir.getAgilidade());
    }
    @Test
    public void falaDoBoromir() {
        Boromir boromir = new Boromir();

        String resultadoEsperado = "One does not simply walk into Mordor.";

        Assert.assertEquals(resultadoEsperado, boromir.falarFrase());
    }
    @Test
    public void toStringBoromir() {
        Boromir boromir = new Boromir();

        String resultadoEsperado = "B";

        Assert.assertEquals(resultadoEsperado, boromir.toString());
    }
    @Test
    public void inteligenciaDoBoromir() {
        Boromir boromir = new Boromir();

        int resultadoEsperado = 3;

        Assert.assertEquals(resultadoEsperado, boromir.getInteligencia());
    }
    @Test
    public void forcaDoBoromir() {
        Boromir boromir = new Boromir();

        int resultadoEsperado = 7;

        Assert.assertEquals(resultadoEsperado, boromir.getForca());
    }
    @Test
    public void grunhidoDoOrc() {
        Orc orc = new Orc();

        String resultadoEsperado = orc.getGrunhido();

        Assert.assertEquals(resultadoEsperado, orc.grunir());
    }
    @Test
    public void agilidadeDoOrc() {
        Orc orc = new Orc();

        int resultadoEsperado = 4;

        Assert.assertEquals(resultadoEsperado, orc.getAgilidade());
    }
    @Test
    public void inteligenciaDoOrc() {
        Orc orc = new Orc();

        int resultadoEsperado = 1;

        Assert.assertEquals(resultadoEsperado, orc.getInteligencia());
    }
    @Test
    public void iconeOrc(){
        Orc orc = new Orc();

        String resultadoEsperado = "O";

        Assert.assertEquals(resultadoEsperado, orc.getIcone());
    }

    @Test
    public void grunhidoDoGoblim() {
        Goblim goblim = new Goblim();

        String resultadoEsperado = goblim.getGrunhido();

        Assert.assertEquals(resultadoEsperado, goblim.grunir());
    }
    @Test
    public void toStringGoblim() {
        Goblim goblim = new Goblim();

        String resultadoEsperado = "M";

        Assert.assertEquals(resultadoEsperado, goblim.toString());
    }
    @Test
    public void forcaDoGoblim() {
        Goblim goblim = new Goblim();

        int resultadoEsperado = 7;

        Assert.assertEquals(resultadoEsperado, goblim.getForca());
    }
    @Test
    public void inteligenciaDoGoblim() {
        Goblim goblim = new Goblim();

        int resultadoEsperado = 1;

        Assert.assertEquals(resultadoEsperado, goblim.getInteligencia());
    }
    @Test
    public void grunhidoDoUrukhai() {
        Urukhai urukhai = new Urukhai();

        String resultadoEsperado = urukhai.getGrunhido();

        Assert.assertEquals(resultadoEsperado, urukhai.grunir());
    }
    @Test
    public void falaDoUrukhai() {
        Urukhai urukhai = new Urukhai();

        String resultadoEsperado = urukhai.getFala();

        Assert.assertEquals(resultadoEsperado, urukhai.falarFrase());
    }
    @Test
    public void envelhecerUrukhai() {
        Urukhai urukhai = new Urukhai();

        int resultadoEsperado = 43;
        urukhai.envelhecer();

        Assert.assertEquals(resultadoEsperado, urukhai.getConstituicao());
    }
    @Test
    public void toStringUrukhai() {
        Urukhai urukhai = new Urukhai();

        String resultadoEsperado = "U";

        Assert.assertEquals(resultadoEsperado, urukhai.toString());
    }
    @Test
    public void inteligenciaDoUrukhai() {
        Urukhai urukhai = new Urukhai();

        int resultadoEsperado = 3;

        Assert.assertEquals(resultadoEsperado, urukhai.getInteligencia());
    }
    @Test
    public void agilidadeDoUrukhai() {
        Urukhai urukhai = new Urukhai();

        int resultadoEsperado = 6;

        Assert.assertEquals(resultadoEsperado, urukhai.getAgilidade());
    }
    @Test
    public void falarElfico() {
        Legolas legolas = new Legolas();

        String resultadoEsperado = "I amar prestar aen, han mathon ne nem, han mathon ne chae, a han noston ned.";;

        Assert.assertEquals(resultadoEsperado, legolas.falarFraseElfica());
    }
    @Test
    public void falaDoLegolas() {

        Legolas legolas = new Legolas();

        String resultadoEsperado = "They're taking the Hobbits to Isengard!";

        Assert.assertEquals(resultadoEsperado, legolas.falarFrase());
    }
    @Test
    public void forcaDoLegolas() {

        Legolas legolas = new Legolas();

        int resultadoEsperado = 5;

        Assert.assertEquals(resultadoEsperado, legolas.getForca());
    }
    @Test
    public void inteligenciaDoLegolas() {
        Legolas legolas = new Legolas();

        int resultadoEsperado = 6;

        Assert.assertEquals(resultadoEsperado, legolas.getInteligencia());
    }
    @Test
    public void toStringLegolas(){
        Legolas legolas = new Legolas();

        String resultadoEsperado = "L";

        Assert.assertEquals(resultadoEsperado, legolas.toString());
    }

    @Test
    public void agilidadeDoAragorn() {
        Aragorn aragorn = new Aragorn();

        int resultadoEsperado = 7;

        Assert.assertEquals(resultadoEsperado, aragorn.getAgilidade());
    }

    @Test
    public void inteligenciaDoAragorn() {
        Aragorn aragorn = new Aragorn();

        int resultadoEsperado = 6;

        Assert.assertEquals(resultadoEsperado, aragorn.getInteligencia());
    }
    @Test
    public void falaDoAragorn() {
        Aragorn aragorn = new Aragorn();

        String resultadoEsperado = "A day may come when the courage of men fails… but it is not THIS day.";

        Assert.assertEquals(resultadoEsperado, aragorn.falarFrase());
    }
    @Test
    public void envelhecerAragorn() {
        Aragorn aragorn = new Aragorn();
        aragorn.envelhecer();

        int resultadoEsperado = 59;

        Assert.assertEquals(resultadoEsperado, aragorn.getConstituicao());
    }
    @Test
    public void toStringAragorn(){
        Aragorn aragorn = new Aragorn();

        String resultadoEsperado = "A";

        Assert.assertEquals(resultadoEsperado, aragorn.toString());
    }
    @Test
    public void toStringSaruman() {
        Saruman saruman = new Saruman();

        String resultadoEsperado = "S";

        Assert.assertEquals(resultadoEsperado, saruman.toString());
    }
    @Test
    public void agilidadeDoSaruman() {
        Saruman saruman = new Saruman();

        int resultadoEsperado = 2;

        Assert.assertEquals(resultadoEsperado, saruman.getAgilidade());
    }
    @Test
    public void forcaDoSaruman() {
        Saruman saruman = new Saruman();

        int resultadoEsperado = 2;

        Assert.assertEquals(resultadoEsperado, saruman.getForca());
    }
    @Test
    public void falaDoSaruman() {
        Saruman saruman = new Saruman();

        String resultadoEsperado = "Against the power of Mordor there can be no victory.";

        Assert.assertEquals(resultadoEsperado, saruman.falarFrase());
    }
    @Test
    public void ressuscitarSaruman() {
        Saruman saruman = new Saruman();
        saruman.setConstituicao(0);

        Assert.assertNull(saruman.ressuscitar());
    }
    @Test
    public void deveRetornarPassos() {
        Personagem personagem = new Personagem();
        personagem.setPassos(1);

        int resultadoEsperado = 1;

        Assert.assertEquals(resultadoEsperado, personagem.getPassos());
    }
    @Test
    public void BuscarPersonagemComParametroDaCasa() {
        Mapa mapa = new Mapa();
        Legolas legolas = new Legolas();

        mapa.inserirPersonagem(0, legolas);
        mapa.buscarLocalizacao(0);

        Assert.assertEquals(legolas, mapa.buscarLocalizacao(0));
    }

    //Fim Testes Metodos

    //Inicio Batalhas/Simulacoes

    @Test
    public void SociedadeDeveVencerQuandoAragornEGimliBatalharemContraOrcEGoblim() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Boromir boromir = new Boromir();
        Gimli gimli = new Gimli();
        Orc orc = new Orc();
        Goblim goblim = new Goblim();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        String resultadoEsperado = "| | | | | | | | | |B|";

        mapa.inserirPersonagem(0, boromir);
        mapa.inserirPersonagem(1, gimli);
        mapa.inserirPersonagem(7, orc);
        mapa.inserirPersonagem(9, goblim);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test(expected = SauronDominaOMundoException.class)
    public void SaurondeveVencerQuandoUrukhaiBatalharContraBoromir() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Boromir boromir = new Boromir();
        Urukhai urukhai = new Urukhai();
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);

        String resultadoEsperado = "| | | | | | | | | |I|";

        mapa.inserirPersonagem(0, boromir);
        mapa.inserirPersonagem(4, urukhai);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test
    public void SociedadeDeveVencerQuandoLegolasBatalharContraOrc() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Legolas legolas = new Legolas();
        Orc orc = new Orc();

        String resultadoEsperado = "| | | | | | | | | |L|";

        mapa.inserirPersonagem(0, legolas);
        mapa.inserirPersonagem(8, orc);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test
    public void SociedadeDeveVencerQuandoAragornBatalharContraOrc() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Aragorn aragorn = new Aragorn();
        Orc orc = new Orc();

        String resultadoEsperado = "| | | | | | | | | |A|";

        mapa.inserirPersonagem(8, orc);
        mapa.inserirPersonagem(0, aragorn);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }
    @Test
    public void SociedadeDeveVencerQuandoGimliBatalharContraOrc() throws PersonagemJaEstaNoMapaException, PosicaoOcupadaException, SauronDominaOMundoException, PersonagemNaoEncontradoNoMapaException {
        Mapa mapa = new Mapa();
        Simulador simulador = new Simulador(mapa);
        Gimli gimli = new Gimli();
        Orc orc = new Orc();

        String resultadoEsperado = "| | | | | | | | | |I|";


        mapa.inserirPersonagem(0, gimli);
        mapa.inserirPersonagem(4, orc);
        simulador.simular();

        Assert.assertEquals(resultadoEsperado, mapa.exibir());
    }

    //Fim Batalhas/Simulacoes

    //Inicio excessoes

    @Test(expected = PersonagemJaEstaNoMapaException.class)
    public void RetornarPersonagemJaEstaNoMapaException() {
        Mapa mapa = new Mapa();
        Goblim goblim = new Goblim();


        mapa.inserirPersonagem(0, goblim);
        mapa.inserirPersonagem(5, goblim);
    }
    @Test(expected = PersonagemNaoEncontradoNoMapaException.class)
    public void ErroAoRetornarPersonagemNaoEncontradoNaCasaBuscada() {
        Mapa mapa = new Mapa();
        Orc orc = new Orc();

        mapa.inserirPersonagem(0, orc);
        mapa.buscarLocalizacao(1);
    }
    @Test(expected = PersonagemNaoEncontradoNoMapaException.class)
    public void RetornarPersonagemNaoEncontradoNoMapaException() {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();
        Urukhai urukhai = new Urukhai();

        mapa.inserirPersonagem(0, aragorn);
        mapa.buscarLocalizacao(urukhai);
    }
    @Test(expected = PosicaoOcupadaException.class)
    public void RetornarPosicaoOcupadaException() {
        Mapa mapa = new Mapa();
        Aragorn aragorn = new Aragorn();

        mapa.inserirPersonagem(0, aragorn);
        mapa.inserirPersonagem(0, aragorn);
    }

    //Fim excessoes


}
