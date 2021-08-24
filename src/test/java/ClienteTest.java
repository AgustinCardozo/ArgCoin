import domain.cliente.*;
import domain.formaDePago.Efectivo;
import domain.servicioCotizacion.*;
import domain.excepcion.MontoInsuficienteException;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.ICriptomoneda;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class ClienteTest {

    static ClientePremium miguel;
    static Cliente pedro;
    static Cliente juana;
    static Criptomoneda bitcoin;
    static Criptomoneda ethereum;
    static Cliente pepe;
    static ICriptomoneda iCriptomoneda;
    static List<Criptomoneda> criptomonedas;

    @BeforeClass
    public static void init() throws IOException {

        iCriptomoneda = new CriptomonedaAdapter();
        criptomonedas = iCriptomoneda.obtenerListadoCriptomonedas();
        pepe = new Cliente(11123123,"pepe", "peponio", "pepe@gmail.com", "medrano","48888888",new Efectivo());

        pedro = new ClienteBasico( 22123123,"Pedro", "Gomez", "pedro@gmail.com", "Belgrano 222", 100,null,"1530900281");
        juana = new ClienteBasico( 33123123,"Juana", "Lugones", "j123_lug@gmail.com", "Corrientes 1200", 100,null,"48989889");
        miguel = new ClientePremium(44123123,"Miguel", "Perez", "holamiguel@gmail.com", "Cordoba 222",new Efectivo(),"48789867");
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
        miguel.setCantidadPesos(10000);
        bitcoin = iCriptomoneda.obtenerListadoCriptomonedas().get(0);
        bitcoin.setCantidad(0.000001);
    }

    @Test
    public void puntosCliente() throws IOException {
        Assert.assertEquals((int)pedro.calcularPuntosArgCoin(),100);
    }

    @Test
    public void puntosReferidos() throws IOException {
        Assert.assertEquals((int)miguel.calcularPuntosArgCoin(),200);
    }
    @Test
    public void comprarBitcoin() throws MontoInsuficienteException {
        miguel.comprarMoneda(bitcoin);
        Assert.assertEquals(miguel.getCantidadPesos(),9999.951915,100);
    }
    @Test
    public void transferirMonedas() throws MontoInsuficienteException{
    miguel.transferirMoneda(bitcoin,0.000000000001,pedro,"Devolucion deuda");
    }

}