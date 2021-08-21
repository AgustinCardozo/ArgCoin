package domain.servicioCriptomoneda;

import java.io.IOException;
import java.util.List;

public class CriptomonedaAdapter implements ICriptomoneda{
    private APICriptomonedas apiCriptomonedas;

    public CriptomonedaAdapter(){
        apiCriptomonedas = APICriptomonedas.getInstance();
    }

    public List<Criptomoneda> obtenerListadoCriptomonedas() throws IOException {
        return apiCriptomonedas.Get_Criptomonedas();
    }
}
