package domain.excepcion;

public class MontoInsuficienteException extends Exception{
    public MontoInsuficienteException(){
        super("Monto insufuciente para operar");
    }
}


