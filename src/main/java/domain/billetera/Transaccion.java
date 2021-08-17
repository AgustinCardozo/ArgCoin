package domain.billetera;

import domain.cliente.*;
import domain.servicioCotizacion.*;

public class Transaccion {
    private Cliente origen;
    private Cliente destino;
    private EstadoTransaccion estado;
    private Moneda moneda;
    private  int cantidad;
    private String detalle;

    public Transaccion(Cliente origen, Cliente destino, EstadoTransaccion estado, Moneda moneda, int cantidad, String detalle) {
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.moneda = moneda;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }
}
