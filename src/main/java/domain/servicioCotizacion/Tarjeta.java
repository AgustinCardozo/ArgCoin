package domain.servicioCotizacion;

public class Tarjeta {
    private int numero;
    private String titular;
    private int cvc;

    public Tarjeta(int numero, String titular, int cvc) {
        this.numero = numero;
        this.titular = titular;
        this.cvc = cvc;
    }
}
