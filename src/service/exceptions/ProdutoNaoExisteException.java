package service.exceptions;

public class ProdutoNaoExisteException extends Exception{

    public ProdutoNaoExisteException(String msg) {
        super(msg);
    }
}
