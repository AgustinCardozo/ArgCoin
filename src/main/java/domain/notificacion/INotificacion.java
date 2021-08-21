package domain.notificacion;

import domain.casaDeCambio.CasaDeCambio;
import domain.cliente.Cliente;

import javax.mail.MessagingException;

public interface INotificacion {
    void enviarMensaje(CasaDeCambio casaDeCambio, Cliente cliente, String mensaje) throws MessagingException;
}
