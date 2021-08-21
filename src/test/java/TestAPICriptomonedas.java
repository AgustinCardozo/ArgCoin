import domain.servicioCriptomoneda.APICriptomonedas;
import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import domain.servicioCriptomoneda.ICriptomoneda;
import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestAPICriptomonedas {
    static ICriptomoneda iCriptomoneda;
    static List<Criptomoneda> criptomonedas;

    @BeforeClass
    public static void init() throws IOException {
        iCriptomoneda = new CriptomonedaAdapter();
        criptomonedas = iCriptomoneda.obtenerListadoCriptomonedas();
    }

    @Test
    public void CantidadCriptoEs100(){
        Assert.assertEquals(100,criptomonedas.size());
    }

    @Test
    public void PrimerElementoDeLaListaEsBitcoin(){
        Assert.assertEquals("bitcoin",criptomonedas.get(0).getId());
    }
}
