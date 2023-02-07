package exceptions;

public class PosicaoOcupadaException extends RuntimeException{
    public PosicaoOcupadaException(String mensagem){
        super(mensagem);
    }
}
