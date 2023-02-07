package exceptions;

public class PersonagemNaoEncontradoNoMapaException extends RuntimeException{
    public PersonagemNaoEncontradoNoMapaException(String mensagem){
        super(mensagem);
    }
}
