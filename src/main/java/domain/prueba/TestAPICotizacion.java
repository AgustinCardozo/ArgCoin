package domain.prueba;

import domain.servicioCotizacion.APICotizacion;
import domain.servicioCotizacion.Moneda;

import java.io.IOException;

public class TestAPICotizacion {
    public static void main(String[] args) throws IOException {
        Moneda moneda = APICotizacion.Get_Cotizacion();
        System.out.println(moneda.toString());
    }
}
