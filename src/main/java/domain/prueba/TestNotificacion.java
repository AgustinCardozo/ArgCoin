package domain.prueba;

import domain.casaDeCambio.CasaDeCambio;
import domain.cliente.Cliente;
import domain.notificacion.MailUtil;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

public class TestNotificacion {
    public static void main(String[] args) throws MessagingException {
        String mensaje = "Esto es un mensaje de prueba";
        Cliente pepe = new Cliente(1,"Pepe","Argento","agus.cardozo96@gmail.com","Av. Boedo 545");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(pepe);

        CasaDeCambio casaDeCambio = new CasaDeCambio("ArgCoin","agus.cardozo96@gmail.com","aca va el password",
                "Av. Corriente 5232", null, clientes, null, null, new MailUtil());

        casaDeCambio.notificar(pepe,mensaje);
    }
}
