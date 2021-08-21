package domain.servicioCotizacion;

import java.io.IOException;

public interface ICotizacion {
    Cotizacion obtenerCotizacion() throws IOException;
}
