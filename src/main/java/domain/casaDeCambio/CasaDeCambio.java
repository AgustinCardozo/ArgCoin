package domain.casaDeCambio;

import domain.billetera.*;
import domain.cliente.*;
import domain.notificacion.INotificacion;
import domain.servicioCotizacion.*;

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
    private BilleteraVirtual billetera;
    private List<Cliente> clientes;
    private List<Cotizacion> monedas;
    private List<Cliente> suscriptores;
    private INotificacion INotificacion;
    private ICotizacion dolarOficial;

    public CasaDeCambio(BilleteraVirtual billetera, List<Cliente> clientes,
                        List<Cotizacion> monedas, List<Cliente> suscriptores, INotificacion INotificacion, ICotizacion cotizacion) throws IOException {
        FileReader file = new FileReader("properties/ArgCoin.properties");

        Properties properties = new Properties();
        properties.load(file);

        this.nombre = properties.getProperty("nombre");
        this.mail = properties.getProperty("mail");
        this.password = properties.getProperty("password");
        this.direccion = properties.getProperty("direccion");
        this.billetera = billetera;
        this.clientes = clientes;
        this.monedas = monedas;
        this.suscriptores = suscriptores;
        this.INotificacion = INotificacion;
        dolarOficial = cotizacion;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword(){
        return password;
    }

    public void agregarSuscriptor(Cliente suscriptor){
        suscriptores.add(suscriptor);
    }

    public void quitarSuscriptor(Cliente suscriptor){
        suscriptores.remove(suscriptor);
    }

    public void notificar(Cliente cliente, String mensaje) throws MessagingException {
        if(clientes.contains(cliente))
            INotificacion.enviarMensaje(this, cliente,mensaje);
    }

/*    public List<Cliente> bajaDePrecio(Criptomoneda criptomoneda){
        if(billetera.getCriptomonedas().contains(criptomoneda)){
            return clientes.stream().filter(cliente -> {
                try {
                    return cliente.getTopeDeVenta() < criptomoneda.consultarContizacionEnPesos();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }).collect(Collectors.toList());
        }
        return null;
    }*/
}
