package domain.servicioCriptomoneda;

import java.io.IOException;
import java.util.List;

public interface ICriptomoneda {
    List<Criptomoneda> obtenerListadoCriptomonedas() throws IOException;
}
