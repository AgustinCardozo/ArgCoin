package domain.billetera;

import domain.excepcion.MontoInsuficienteException;

public class EstadoRechazado implements EstadoTransaccion {


    @Override
    public void imprimirDetalle() {
        System.out.println("La transacción se rechazó");
    }

    @Override
    public void cancelarOperacion(Transaccion transaccion) {
        System.out.println("La transacción ya se encuentra rechazada");
    }

    @Override
    public void repetirOperacion(Transaccion transaccion) throws MontoInsuficienteException {
        transaccion.getOrigen().transferirMoneda(transaccion.getMoneda(), transaccion.getCantidad(), transaccion.getDestino(), transaccion.getDetalle());
    }
}
