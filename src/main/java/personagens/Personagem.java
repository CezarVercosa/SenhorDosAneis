package personagens;

import classes.Classes;

public class Personagem {
    private int forca;
    private int agilidade;
    private int inteligencia;
    protected int constituicao;
    private String fala;

    public Personagem(int forca, int agilidade, int inteligencia, int constituicao, int passos, Classes classe, boolean sociedadeDoAnel, String icone) {
        this.setPassos(passos);
        this.setConstituicao(constituicao);
        this.setAgilidade(agilidade);
        this.setInteligencia(inteligencia);
        this.setForca(forca);
        this.setClassePersonagem(classe);
        this.setSociedadeDoAnel(sociedadeDoAnel);
        this.setIcone(icone);
    }
    public Personagem() {
        setClassePersonagem(this.classePersonagem);
        setSociedadeDoAnel(this.sociedadeDoAnel);
    }
    public String getFala() {
        return fala;
    }
    public void setFala(String fala) {
        this.fala = fala;
    }
    public String getGrunhido() {
        return grunhido;
    }
    public void setGrunhido(String grunhido) {
        this.grunhido = grunhido;
    }
    private int passos;
    private String grunhido;
    private String icone;
    public String toString() {
        return this.icone;
    }
    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
    private boolean sociedadeDoAnel;
   private Classes classePersonagem;
    public int getConstituicao() {
        return constituicao;
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public int getAgilidade() {
        return agilidade;
    }
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }
    public int getInteligencia() {
        return inteligencia;
    }
    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }
    public Classes getClassePersonagem() {
        return classePersonagem;
    }
    public void setClassePersonagem(Classes classePersonagem) {
        this.classePersonagem = classePersonagem;
    }
    public boolean isSociedadeDoAnel() {
        return sociedadeDoAnel;
    }
    public void setSociedadeDoAnel(boolean sociedadeDoAnel) {
        this.sociedadeDoAnel = sociedadeDoAnel;
    }
    public int getPassos() {
        return passos;
    }
    public void setPassos(int passos) {
        this.passos = passos;
    }
    public static Classes classe;
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
}
