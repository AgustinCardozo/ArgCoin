package domain.billetera;

public interface EstadoTransaccion {

    public void imprimirDetalle();

    public void cancelarOperacion(Transaccion transaccion);

    public void repetirOperacion(Transaccion transaccion);


}
