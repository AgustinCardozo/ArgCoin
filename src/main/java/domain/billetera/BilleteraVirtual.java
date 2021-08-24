package domain.billetera;

import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import domain.servicioCriptomoneda.ICriptomoneda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BilleteraVirtual {
    private List<Criptomoneda> criptomonedas = new ArrayList<>();
    ICriptomoneda iCriptomoneda;

    public BilleteraVirtual() throws IOException {
        iCriptomoneda = new CriptomonedaAdapter();
        criptomonedas = iCriptomoneda.obtenerListadoCriptomonedas();
    }

    public double saldoTotal() {
        double saldo = this.criptomonedas.stream().mapToDouble(Criptomoneda::valorMoneda).sum();
        return saldo;
    }

    public boolean adquirirMoneda(Criptomoneda monedaAdquirida) {
            for (Criptomoneda moneda : criptomonedas) {
                if (moneda.getId().equals(monedaAdquirida.getId())) {
                    moneda.setCantidad(moneda.getCantidad() + monedaAdquirida.getCantidad());
                    return true;
                }
            }
            criptomonedas.add(monedaAdquirida);
            return true;
    }

    public boolean venderMoneda(Criptomoneda monedaAVender, double cantidad){
        for(Criptomoneda moneda : criptomonedas){
            if (moneda.getId() == (monedaAVender.getId())){
                moneda.setCantidad(moneda.getCantidad() - cantidad);
                return true;
            }
        }
        return false;
    }

    public boolean transferirMoneda(Criptomoneda monedaAVender, double cantidad){
        for(Criptomoneda moneda : criptomonedas){
            if (moneda.getId().equals(monedaAVender.getId())){
                moneda.setCantidad(moneda.getCantidad() - cantidad);
                return true;
            }
        }
        return false;
    }

    public List<Criptomoneda> getCriptomonedas() {
        return criptomonedas;
    }
}


