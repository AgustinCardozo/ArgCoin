package domain.prueba;

import domain.servicioCotizacion.APICotizacion;
import domain.servicioCotizacion.Cotizacion;
import domain.servicioCriptomoneda.APICriptomonedas;
import domain.servicioCriptomoneda.Criptomoneda;

import java.io.IOException;
import java.util.List;

public class TestAPICotizacion {
    public static void main(String[] args) throws IOException {
        Cotizacion moneda = APICotizacion.Get_Cotizacion();
        System.out.println(moneda.toString());

        List<Criptomoneda> criptomonedas = APICriptomonedas.Get_Criptomonedas();
        System.out.println("\nValor en peso del bitcoin: "+criptomonedas.get(0).consultarContizacionEnPesos());
        System.out.println("Valor en dolar del bitcoin: "+criptomonedas.get(0).getPrice());

    }
}
