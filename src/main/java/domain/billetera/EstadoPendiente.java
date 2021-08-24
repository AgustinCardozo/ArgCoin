package domain.billetera;

import domain.excepcion.MontoInsuficienteException;

public class EstadoPendiente implements EstadoTransaccion{


    @Override
    public void imprimirDetalle() {
        System.out.println("La transacción está pendiente");
    }

    @Override
    public void cancelarOperacion(Transaccion transaccion) {
        transaccion.setEstado(new EstadoRechazado());
    }

    @Override
        public void repetirOperacion(Transaccion transaccion) throws MontoInsuficienteException {
            transaccion.getOrigen().transferirMoneda(transaccion.getMoneda(),transaccion.getCantidad(),transaccion.getDestino(),transaccion.getDetalle());

    }
}
