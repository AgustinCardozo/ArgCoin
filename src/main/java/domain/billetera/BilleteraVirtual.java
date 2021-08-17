package domain.billetera;

import domain.servicioCotizacion.Moneda;
import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtual {
    private List<Moneda> monedas = new ArrayList<>();

    public double saldoTotal() {
        double saldo = this.monedas.stream().mapToDouble(Moneda::valorMoneda).sum();
        return saldo;
    }

    public boolean adquirirMoneda(Moneda monedaAdquirida) {
            for (Moneda moneda : monedas) {
                if (moneda.getId() == (monedaAdquirida.getId())) {
                    moneda.setCantidad(moneda.getCantidad() + monedaAdquirida.getCantidad());
                    return true;
                }
            }
            monedas.add(monedaAdquirida);
            return true;
    }
}


