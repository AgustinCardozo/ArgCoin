import domain.cliente.*;
import domain.formaDePago.Efectivo;
import domain.servicioCotizacion.*;
import domain.excepcion.MontoInsuficienteException;
import domain.servicioCriptomoneda.Criptomoneda;
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
    static Criptomoneda ethereum;
    static Cliente pepe;

    @BeforeClass
    public static void init() throws IOException {
        pepe = new Cliente(11123123,"pepe", "peponio", "pepe@gmail.com", "medrano","48888888",new Efectivo());

        pedro = new Cliente( 22123123,"Pedro", "Gomez", "pedro@gmail.com", "Belgrano 222", "59889988",new Efectivo());
        juana = new Cliente( 33123123,"Juana", "Lugones", "j123_lug@gmail.com", "Corrientes 1200", "48989889",new Efectivo());
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
        bitcoin = new Criptomoneda("bitcoin","100",100);
        ethereum = new Criptomoneda("1","1",1);
    }

    @Test
    public void puntosCliente() throws IOException {
        Assert.assertEquals((int)pedro.calcularPuntosArgCoin(),12);
    }

    @Test
    public void puntosReferidos() throws IOException {
        Assert.assertEquals((int)miguel.calcularPuntosArgCoin(),22);
    }
    @Test
    public void comprarBitcoin() throws MontoInsuficienteException {
        miguel.comprarMoneda(bitcoin);
        Assert.assertEquals(miguel.getCantidadPesos(),90,0);
    }
    @Test
    public void transferirMonedas() throws MontoInsuficienteException{
    miguel.transferirMoneda(bitcoin,0.1,pedro,"Devolucion deuda");
    }

}