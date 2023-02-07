package simulador;

import exceptions.SauronDominaOMundoException;
import mapa.Mapa;
import personagens.Personagem;

import java.util.ArrayList;
import java.util.List;


public class Simulador {
    protected static final List<Personagem> listaDosPersonagens = new ArrayList<>();
    public Simulador(Mapa mapa) {
        this.mapa = mapa;
    }
    public Mapa mapa;

    public Mapa andar(Mapa mapa, Personagem personagem) {
        for (int i = 0; i < personagem.getPassos(); i++) {
            int posicao = mapa.buscarLocalizacao(personagem);
            if (personagem.isSociedadeDoAnel()) {
                if(posicao == 9) {
                    return mapa;
                }
                mapa.mapaDoJogo[posicao+1] = personagem;
                mapa.removerPersonagem(posicao);
            } else {
                mapa.mapaDoJogo[posicao - 1] = personagem;
                mapa.removerPersonagem(posicao);
            }
        }
        return mapa;
    }
    public boolean MesmaSociedade(Personagem personagemUm, Personagem personagemDois) {
        if (personagemUm.isSociedadeDoAnel() == personagemDois.isSociedadeDoAnel())
            return true;
        return false;
    }
    public void removePersonagemMorto(Personagem personagemAAtacar, Personagem personagemSelecionado) {
        if (personagemAAtacar.getConstituicao() <= 0) {
            alvoMorto(personagemAAtacar, personagemSelecionado);
        }
    }
    public void alvoMorto(Personagem personagemAAtacar, Personagem personagemSelecionado) {
        int posicao = mapa.buscarLocalizacao(personagemAAtacar);
        mapa.removerPersonagem(posicao);
        andar(mapa, personagemSelecionado);
    }
    public void ataque(Personagem personagemSelecionado, Personagem personagemAAtacar) {
        switch (personagemSelecionado.getClassePersonagem()) {
            case MAGO:
                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getInteligencia());
                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                break;
            case GUERREIRO:
                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getForca() * 2);
                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                break;

        }
    }
    public void simular() {
        Personagem personagemSelecionado;
        Personagem personagemAAtacar;
        Personagem personagemPassado = null;
        Personagem verificacaoDoPersonagem;
        Boolean AndarDoMago = false;

        while (true) {
            for (int i = 0; i < mapa.mapaDoJogo.length; i++) {

                int contadorSociedadeDoAnel = 0;

                listaDosPersonagens.clear();
                for (int j = 0; j < mapa.mapaDoJogo.length; j++) {
                    if (mapa.mapaDoJogo[j] == null) {
                        listaDosPersonagens.add(mapa.mapaDoJogo[j]);
                    } else {
                        verificacaoDoPersonagem = mapa.mapaDoJogo[j];
                        if (verificacaoDoPersonagem.isSociedadeDoAnel()) {
                            contadorSociedadeDoAnel += 1;
                        }
                    }
                }
                if (contadorSociedadeDoAnel == 0) {
                    throw new SauronDominaOMundoException("A humanidade sofre perante a tirania de Sauron.");
                }
                if (listaDosPersonagens.size() == 9) {
                    personagemPassado = null;
                    AndarDoMago = true;
                } else{
                    AndarDoMago = false;
                }
                if (mapa.mapaDoJogo[i] != null) {
                    personagemSelecionado = mapa.mapaDoJogo[i];
                    if (personagemPassado != personagemSelecionado) {
                        personagemPassado = personagemSelecionado;
                        if (personagemSelecionado.isSociedadeDoAnel() && i == 9) {
                            return;
                        }
                        switch (personagemSelecionado.getClassePersonagem()) {
                            case MAGO:
                                for (int h = 0; h < mapa.mapaDoJogo.length; h++) {
                                    if (mapa.mapaDoJogo[h] != null) {
                                        personagemAAtacar = mapa.buscarLocalizacao(h);
                                        if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                            personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getInteligencia());
                                            if (personagemAAtacar.getConstituicao() <= 0) {
                                                mapa.removerPersonagem(h);
                                            }
                                        }
                                    } else {
                                        if (AndarDoMago) {
                                            andar(mapa, personagemSelecionado);
                                        }
                                    }
                                }
                                break;
                            case GUERREIRO:
                                if (personagemSelecionado.isSociedadeDoAnel()) {
                                    if (mapa.mapaDoJogo[i + 1] != null) {
                                        personagemAAtacar = mapa.buscarLocalizacao(i + 1);
                                        if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                            ataque(personagemSelecionado, personagemAAtacar);
                                        }
                                    } else {
                                        andar(mapa, personagemSelecionado);
                                    }
                                } else {
                                    if (mapa.mapaDoJogo[i - 1] != null) {
                                        personagemAAtacar = mapa.buscarLocalizacao(i - 1);
                                        if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                            ataque(personagemSelecionado, personagemAAtacar);
                                        }
                                    } else {
                                        andar(mapa, personagemSelecionado);
                                    }
                                }
                                break;
                            case ARQUEIRO:
                                    if (personagemSelecionado.isSociedadeDoAnel()) {
                                        if (i == 8) {
                                            if (mapa.mapaDoJogo[i+1] != null) {
                                                personagemAAtacar = mapa.buscarLocalizacao(i + 1);
                                                if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                    personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 1);
                                                    removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                                    break;
                                                }
                                            }
                                                andar(mapa, personagemSelecionado);
                                                break;
                                        } else if (i == 7) {
                                            if (mapa.mapaDoJogo[i+2] != null) {
                                                personagemAAtacar = mapa.buscarLocalizacao(i + 1);
                                                if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                    personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 2);
                                                    removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                                    break;
                                                }
                                            } else {
                                                andar(mapa, personagemSelecionado);
                                                break;
                                            }
                                        }
                                            if (mapa.mapaDoJogo[i + 3] != null) {
                                                personagemAAtacar = mapa.buscarLocalizacao(i + 3);
                                                if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                    personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 3);
                                                    if (personagemAAtacar.getConstituicao() <= 0) {
                                                        mapa.removerPersonagem(i + 3);
                                                        if(mapa.mapaDoJogo[i+2] != null) {
                                                            mapa.mapaDoJogo[i+1] = personagemSelecionado;
                                                            mapa.removerPersonagem(i);
                                                        } else {
                                                            andar(mapa, personagemSelecionado);
                                                        }
                                                    }
                                                }
                                            }
                                            else if (mapa.mapaDoJogo[i+1] != null) {
                                                personagemAAtacar = mapa.buscarLocalizacao(i + 1);
                                                if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                    personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 1);
                                                    removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                                }
                                            } else {
                                                andar(mapa, personagemSelecionado);
                                            }
                                    }
                                    else {
                                        if (i == 1) {
                                        if (mapa.mapaDoJogo[i-1] != null) {
                                            personagemAAtacar = mapa.buscarLocalizacao(i - 1);
                                            if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 1);
                                                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                                break;
                                            }
                                        } else {
                                            andar(mapa, personagemSelecionado);
                                            break;
                                        }
                                    } else if (i == 2) {
                                        if (mapa.mapaDoJogo[i-2] != null) {
                                            personagemAAtacar = mapa.buscarLocalizacao(i - 2);
                                            if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 2);
                                                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                                break;
                                            }
                                        } else {
                                            andar(mapa, personagemSelecionado);
                                            break;
                                        }
                                    }
                                        if(mapa.mapaDoJogo[i-3] != null) {
                                            personagemAAtacar = mapa.buscarLocalizacao(i - 3);
                                            if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 3);
                                                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                            }
                                        }
                                        else if (mapa.mapaDoJogo[i-2] != null) {
                                            personagemAAtacar = mapa.buscarLocalizacao(i - 2);
                                            if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 2);
                                                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                            }
                                        }
                                        else if (mapa.mapaDoJogo[i-1] != null) {
                                            personagemAAtacar = mapa.buscarLocalizacao(i - 1);
                                            if (!(MesmaSociedade(personagemSelecionado, personagemAAtacar))) {
                                                personagemAAtacar.setConstituicao(personagemAAtacar.getConstituicao() - personagemSelecionado.getAgilidade() * 1);
                                                removePersonagemMorto(personagemAAtacar, personagemSelecionado);
                                            }
                                        } else {
                                            andar(mapa, personagemSelecionado);
                                        }
                                    }
                                break;
                        }
                    }
                    if (i == 9) {
                        i = -1;
                    }
                }
            }
        }
    }
}
