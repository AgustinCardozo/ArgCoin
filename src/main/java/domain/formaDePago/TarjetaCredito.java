package domain.formaDePago;

public class TarjetaCredito implements FormaDePago{
    private int numero;
    private String titular;
    private int cvc;

    public TarjetaCredito(int numero, String titular, int cvc) {
        this.numero = numero;
        this.titular = titular;
        this.cvc = cvc;
    }

    @Override
    public double pagar(double importe) {
        return importe * 1.12;
    }
}
