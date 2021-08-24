package domain.billetera;

import domain.cliente.*;
import domain.servicioCotizacion.*;

public class Transaccion {
    private Cliente origen;
    private Cliente destino;
    private EstadoTransaccion estado;
    private double cantidad;
    private String moneda;
    private String detalle;


    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Transaccion(Cliente origen, Cliente destino, EstadoTransaccion estado,String moneda, double cantidad, String detalle) {
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.moneda = moneda;
    }
    TransaccionMapper oMapper = new TransaccionMapper(this.origen, this.destino, this.estado,this.moneda, this.cantidad,this.detalle);
}
