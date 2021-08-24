package domain.billetera;

import domain.excepcion.MontoInsuficienteException;

public class EstadoEfectuado implements  EstadoTransaccion {
    @Override
    public void imprimirDetalle() {
        System.out.println("Transacción efectuada con éxito");
    }

    @Override
    public void cancelarOperacion(Transaccion transaccion) {
        System.out.println("No se puede cancelar, operación efectuada");

    }

    @Override
    public void repetirOperacion(Transaccion transaccion) throws MontoInsuficienteException {
        transaccion.getOrigen().transferirMoneda(transaccion.getMoneda(),transaccion.getCantidad(),transaccion.getDestino(),transaccion.getDetalle());

    }
}
