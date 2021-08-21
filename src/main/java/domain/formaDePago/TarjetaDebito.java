package domain.formaDePago;

public class TarjetaDebito implements FormaDePago{
    private int numero;
    private String titular;
    private int cvc;

    public TarjetaDebito(int numero, String titular, int cvc) {
        this.numero = numero;
        this.titular = titular;
        this.cvc = cvc;
    }

    @Override
    public double pagar(double importe) {
        return importe * 1.05;
    }
}
