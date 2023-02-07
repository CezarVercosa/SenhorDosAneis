package mapa;

import exceptions.PersonagemJaEstaNoMapaException;
import exceptions.PersonagemNaoEncontradoNoMapaException;
import exceptions.PosicaoOcupadaException;
import personagens.Personagem;

public class Mapa {

    public Personagem[] mapaDoJogo = new Personagem[10];

    public String exibir() {
        String separacaoCasasMapa = "|";
        for (int i = 0; i<mapaDoJogo.length; i++) {
            if (mapaDoJogo[i] == null) {
                separacaoCasasMapa += (" "+"|");
            } else {
                separacaoCasasMapa += (mapaDoJogo[i].toString()+"|");
            }
        }
        return separacaoCasasMapa;
    }
    public void inserirPersonagem(int posicao, Personagem personagem){
        if (mapaDoJogo[posicao] != null) {
            throw new PosicaoOcupadaException("Posição já está ocupada.");
        }
        for (int i = 0; i<mapaDoJogo.length; i++) {
            if (mapaDoJogo[i] == personagem){
                throw new PersonagemJaEstaNoMapaException("Personagem já está no mapa do jogo.");
            }
        }
        mapaDoJogo[posicao] = personagem;
    }

    public void removerPersonagem(int posicao) {
        mapaDoJogo[posicao] = null;
    }


    public Personagem buscarLocalizacao(int posicao) {
        if (mapaDoJogo[posicao] != null) {
            return mapaDoJogo[posicao];
        } else {
            throw new PersonagemNaoEncontradoNoMapaException("Personagem não encontrado no mapa do jogo.");
        }

    }
    public int buscarLocalizacao(Personagem personagem) {
        for (int i = 0; i < mapaDoJogo.length; i++) {
            if (mapaDoJogo[i] == personagem) {
                return i;
            }
        }
        throw new PersonagemNaoEncontradoNoMapaException("Personagem não localizado no mapa do jogo.");
    }



}
