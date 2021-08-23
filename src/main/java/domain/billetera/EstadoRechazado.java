package domain.billetera;

public class EstadoRechazado implements EstadoTransaccion {

    public void reintentarOperacion() {

    }

    @Override
    public void imprimirDetalle() {
        System.out.println("La transacción se rechazó");
    }

    @Override
    public void cancelarOperacion(Transaccion transaccion) {
        System.out.println("La transacción ya se encuentra rechazada");
    }

    @Override
    public void repetirOperacion(Transaccion transaccion) {

    }
}
