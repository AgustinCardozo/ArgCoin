package domain.prueba;

import domain.casaDeCambio.CasaDeCambio;
import domain.cliente.Cliente;
import domain.formaDePago.Efectivo;
import domain.notificacion.Mail;
import domain.servicioCotizacion.CotizacionAdapter;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestNotificacion {
    public static void main(String[] args) throws MessagingException, IOException {
        String mensaje = "Esto es un mensaje de prueba";
        Cliente pepe = new Cliente(1,"Pepe","Argento","agus.cardozo96@gmail.com","Av. Boedo 545", new Efectivo());

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(pepe);

        CasaDeCambio casaDeCambio = new CasaDeCambio(null, clientes, null, null, new Mail(),new CotizacionAdapter());

        casaDeCambio.notificar(pepe,mensaje);
    }
}
