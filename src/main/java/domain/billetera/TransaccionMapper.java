package domain.billetera;


import domain.cliente.Cliente;
import domain.servicioCotizacion.Cotizacion;

public class TransaccionMapper {
    private Cliente origen;
    private Cliente destino;
    private EstadoTransaccion estado;
    private int moneda;
    private  double cantidad;
    private String detalle;

    public TransaccionMapper(Cliente origen, Cliente destino, EstadoTransaccion estado, int moneda, double cantidad, String detalle){
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.moneda = moneda;
        this.cantidad = cantidad;
        this.detalle = detalle;

    }


    public int insert() {
        TransaccionDAO transaccionDAO = new TransaccionDAO();
       return transaccionDAO.insert(this.origen.getId(),this.destino.getId(),this.moneda,this.cantidad);
    }
}
