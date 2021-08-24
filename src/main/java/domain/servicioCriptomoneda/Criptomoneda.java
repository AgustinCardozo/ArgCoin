package domain.servicioCriptomoneda;

import domain.servicioCotizacion.APICotizacion;
import domain.servicioCotizacion.CotizacionAdapter;
import domain.servicioCotizacion.ICotizacion;

import java.io.IOException;

public class Criptomoneda {
    private String id;
    private String priceUsd;
    private ICotizacion cotizacionDolarOficial;
    private double cantidad;

    public Criptomoneda(String id, String priceUsd, int cantidad) throws IOException {
        this.id = id;
        this.priceUsd = priceUsd;
        this.cotizacionDolarOficial = new CotizacionAdapter();
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public double getPrice(){
        double precioEnPeso = Double.parseDouble(priceUsd);
        return Math.round(precioEnPeso*100)/100;
    }

    public double consultarContizacionEnPesos() throws IOException {
        double cotizacionOficial = cotizacionDolarOficial.obtenerCotizacion().getVenta() * this.getPrice();
        return Math.round(cotizacionOficial*100)/100;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double valorMoneda(){
        return this.getPrice() *this.cantidad;
    }

    @Override
    public String toString(){
        return "ID: "+id +"\tPrice: "+ getPrice();
    }
}
