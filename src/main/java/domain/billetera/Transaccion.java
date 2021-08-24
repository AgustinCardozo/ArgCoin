package domain.billetera;

import domain.cliente.*;
import java.util.Date;
import domain.servicioCotizacion.*;
import domain.servicioCriptomoneda.Criptomoneda;

public class Transaccion {
    private Cliente origen;

    public Cliente getOrigen() {
        return origen;
    }

    public Cliente getDestino() {
        return destino;
    }

    public EstadoTransaccion getEstado() {
        return estado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public Criptomoneda getMoneda() {
        return moneda;
    }

    public String getDetalle() {
        return detalle;
    }

    private Cliente destino;
    private EstadoTransaccion estado;
    private double cantidad;
    private Criptomoneda moneda;
    private String detalle;
    private Date fecha;


    public void setEstado(EstadoTransaccion estado) {
        this.estado = estado;
    }

    public Transaccion(Cliente origen, Cliente destino, EstadoTransaccion estado,Criptomoneda moneda, double cantidad, String detalle) {
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.cantidad = cantidad;
        this.detalle = detalle;
        this.moneda = moneda;
        this.fecha = new Date();
    }

    TransaccionMapper oMapper = new TransaccionMapper(this.origen, this.destino, this.estado,this.moneda.getId(), this.cantidad,this.detalle);
}
