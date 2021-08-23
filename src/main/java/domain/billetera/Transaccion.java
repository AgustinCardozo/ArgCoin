package domain.billetera;

import domain.cliente.*;
import domain.servicioCotizacion.*;

public class Transaccion {
    private Cliente origen;
    private Cliente destino;
    private EstadoTransaccion estado;
    private Cotizacion cotizacion;
    private  int cantidad;
    private String detalle;

    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Transaccion(Cliente origen, Cliente destino, EstadoTransaccion estado, Cotizacion cotizacion, int cantidad, String detalle) {
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.cotizacion = cotizacion;
        this.cantidad = cantidad;
        this.detalle = detalle;
    }
    TransaccionMapper oMapper = new TransaccionMapper(this.origen, this.destino, this.estado, this.cotizacion.getId(), this.cantidad,this.detalle);
}
