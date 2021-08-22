package domain.casaDeCambio;

import domain.billetera.*;
import domain.cliente.*;
import domain.excepcion.MontoInsuficienteException;
import domain.notificacion.INotificacion;
import domain.servicioCotizacion.*;
import domain.servicioCriptomoneda.Criptomoneda;
import domain.servicioCriptomoneda.CriptomonedaAdapter;
import domain.servicioCriptomoneda.ICriptomoneda;

import javax.mail.MessagingException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class CasaDeCambio {
    private int id;
    private String nombre;
    private String mail;
    private String password;
    private String direccion;
    private List<Cliente> clientes;
    private List<Criptomoneda> monedas;
    private INotificacion INotificacion;
    private ICotizacion dolarOficial;

    public CasaDeCambio(List<Cliente> clientes, INotificacion INotificacion, ICotizacion cotizacion) throws IOException {
        FileReader file = new FileReader("properties/ArgCoin.properties");

        Properties properties = new Properties();
        properties.load(file);

        this.nombre = properties.getProperty("nombre");
        this.mail = properties.getProperty("mail");
        this.password = properties.getProperty("password");
        this.direccion = properties.getProperty("direccion");
        this.clientes = clientes;
        this.monedas = new CriptomonedaAdapter().obtenerListadoCriptomonedas();
        this.INotificacion = INotificacion;
        this.dolarOficial = cotizacion;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword(){
        return password;
    }

/*    public void vender(Cliente cliente, Criptomoneda criptomoneda) throws MontoInsuficienteException, IOException, MessagingException {
        if(clientes.contains(cliente)){
            cliente.comprarMoneda(criptomoneda);
            this.notificar(cliente,"Su compra fue realizado con exito");
        }
    }*/

    public void notificar(Cliente cliente, String mensaje) throws MessagingException {
        if(clientes.contains(cliente))
            INotificacion.enviarMensaje(this, cliente,mensaje);
    }
}
