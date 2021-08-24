package domain.billetera;

import domain.excepcion.MontoInsuficienteException;

public interface EstadoTransaccion {

    public void imprimirDetalle();

    public void cancelarOperacion(Transaccion transaccion);

    public void repetirOperacion(Transaccion transaccion) throws MontoInsuficienteException;


}
