package domain.notificacion;

import domain.casaDeCambio.CasaDeCambio;
import domain.cliente.Cliente;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MailAdapter implements INotificacion {
    @Override
    public void enviarMensaje(CasaDeCambio casaDeCambio, Cliente cliente, String mensaje) throws MessagingException {
        System.out.println("Preparando el mail a enviar");

        Properties properties = new Properties();
        ConfigureProperties(properties);

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(casaDeCambio.getMail(), casaDeCambio.getPassword());
            }
        });

        Message message = PrepareMessage(session, cliente, casaDeCambio,mensaje);

        Transport.send(message);
        System.out.println("Mensaje enviado exitosamente");
    }

    private static Message PrepareMessage(Session session, Cliente cliente, CasaDeCambio casaDeCambio, String msj) {
        try{
            Message message = new MimeMessage(session);
            ConfigureMessage(message, casaDeCambio, cliente,msj);
            return message;
        }catch (Exception exception){
            Logger.getLogger(MailAdapter.class.getName()).log(Level.SEVERE,null,exception);
        }
        return null;
    }

    public static void ConfigureProperties(Properties properties){
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
        //properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");
    }

    private static void ConfigureMessage(Message message, CasaDeCambio casaDeCambio, Cliente cliente, String msj) throws MessagingException {
        message.setFrom(new InternetAddress(casaDeCambio.getMail()));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(cliente.getMail()));
        message.setSubject("Mail from Java App");
        //String htmlCode = "<h1> TEST MAIL SEND </h1> <br/> <h2> Example </b></h2>";
        //message.setText("Hey there\n Look my email!");
        //message.setContent(htmlCode,"text/html");
        message.setText(msj);
    }

}
