import domain.cliente.*;
import domain.servicioCotizacion.*;
import domain.excepcion.MontoInsuficienteException;
import domain.servicioCriptomoneda.APICriptomonedas;
import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;


public class ClienteTest {

    static ClientePremium miguel;
    static Cliente pedro;
    static Cliente juana;
    static Criptomoneda bitcoin;

    @BeforeClass
    public static void init() throws IOException {
        pedro = new ClienteBasico(38403572, "Pedro", "Gomez", "pedro@gmail.com", "Belgrano 222", 12);
        juana = new ClienteBasico(18909112, "Juana", "Lugones", "j123_lug@gmail.com", "Corrientes 1200", 10);
        miguel = new ClientePremium(40122333, "Miguel", "Perez", "holamiguel@gmail.com", "Cordoba 222");
        try{
            miguel.agregarReferido(pedro);
        }catch (Exception e){
            System.out.println("No se puede agregar referido");
        }
        try{
            miguel.agregarReferido(juana);
        }catch (Exception e){
            System.out.println("No se puede agregar referido");
        }
        try{
            miguel.agregarReferido(juana);
        }catch (Exception e){
            System.out.println("No se puede agregar referido");
        }
        miguel.setCantidadPesos(500000);
        bitcoin = new CriptomonedaAdapter().obtenerListadoCriptomonedas().get(0);//new Moneda(1,"16/08","10","8",2);
    }

    @Test
    public void puntosCliente() throws IOException {
        Assert.assertEquals((int)pedro.calcularPuntosArgCoin(),12);
    }

    @Test
    public void puntosReferidos() throws IOException {
        Assert.assertEquals((int)miguel.calcularPuntosArgCoin(),22);
    }


    //Rompe porque varia continuamente el valor de bitcoin
    /*@Test
    public void comprarBitcoin() throws MontoInsuficienteException{
        miguel.comprarMoneda(bitcoin);
        Assert.assertEquals(miguel.getCantidadPesos(),452974,0);
    }*/

}