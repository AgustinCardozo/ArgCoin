package domain.servicioCotizacion;

import java.io.IOException;

public class CotizacionAdapter implements ICotizacion{
    private APICotizacion apiCotizacion;

    public CotizacionAdapter(){
        this.apiCotizacion = APICotizacion.getInstance();
    }

    public Cotizacion obtenerCotizacion() throws IOException {
        return apiCotizacion.Get_Cotizacion();
    }
}
