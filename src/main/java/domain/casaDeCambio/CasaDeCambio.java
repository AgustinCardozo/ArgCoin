package domain.casaDeCambio;

import domain.billetera.*;
import domain.cliente.*;
import domain.notificacion.NotificacionTarget;
import domain.servicioCotizacion.*;

import javax.mail.MessagingException;
import java.util.List;


//Hacerlo singleton?
public class CasaDeCambio {
    private  int id;
    private String nombre;
    private String mail;
    private String password;
    private String direccion;
    private BilleteraVirtual billetera;
    private List<Cliente> clientes;
    private List<Moneda> monedas;
    private List<Cliente> suscriptores;
    private NotificacionTarget notificacionTarget;

    public CasaDeCambio(String nombre, String mail, String password,String direccion, BilleteraVirtual billetera, List<Cliente> clientes,
                        List<Moneda> monedas, List<Cliente> suscriptores, NotificacionTarget notificacionTarget){
        this.nombre = nombre;
        this.mail = mail;
        this.password = password;
        this.direccion = direccion;
        this.billetera = billetera;
        this.clientes = clientes;
        this.monedas = monedas;
        this.suscriptores = suscriptores;
        this.notificacionTarget = notificacionTarget;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword(){
        return password;
    }

    public void notificar(Cliente cliente, String mensaje) throws MessagingException {
        if(clientes.contains(cliente))
            notificacionTarget.enviarMensaje(this, cliente,mensaje);
    }
}
