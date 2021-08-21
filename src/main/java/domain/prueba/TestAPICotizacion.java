package domain.prueba;

import domain.billetera.BilleteraVirtual;
import domain.servicioCotizacion.APICotizacion;
import domain.servicioCotizacion.Cotizacion;
import domain.servicioCotizacion.CotizacionAdapter;
import domain.servicioCotizacion.ICotizacion;
import domain.servicioCriptomoneda.APICriptomonedas;
import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import domain.servicioCriptomoneda.ICriptomoneda;

import java.io.IOException;
import java.util.List;

public class TestAPICotizacion {
    public static void main(String[] args) throws IOException {
        ICotizacion iCotizacion = new CotizacionAdapter();
        System.out.println(iCotizacion.obtenerCotizacion().toString());

        //BilleteraVirtual billeteraVirtual = new BilleteraVirtual();
        //System.out.println("\n"+billeteraVirtual.getCriptomonedas().get(0).toString());

    }
}
