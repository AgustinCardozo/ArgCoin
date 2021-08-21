package domain.formaDePago;

public class Efectivo implements FormaDePago{
    @Override
    public double pagar(double importe) {
        return importe * 1;
    }
}
