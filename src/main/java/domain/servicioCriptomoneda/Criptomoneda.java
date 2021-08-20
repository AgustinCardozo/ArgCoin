package domain.servicioCriptomoneda;

import domain.servicioCotizacion.APICotizacion;

import java.io.IOException;

public class Criptomoneda {
    private String id;
    private int rank;
    private String symbol;
    private String priceUsd;
    //private Moneda cotizacionDolarOficial = APICotizacion.Get_Cotizacion();
    private int cantidad;

    public Criptomoneda(String id, int rank, String symbol, String priceUsd) throws IOException {
        this.id = id;
        this.rank = rank;
        this.symbol = symbol;
        this.priceUsd = priceUsd;
        //this.cotizacionDolarOficial = APICotizacion.Get_Cotizacion();
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public int getRank() {
        return rank;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice(){
        double precioEnPeso = Double.parseDouble(priceUsd);
        return Math.round(precioEnPeso*100)/100;
    }

    public double consultarContizacionEnPesos() throws IOException {
        double cotizacionOficial = APICotizacion.Get_Cotizacion().getVenta() * this.getPrice();
        return Math.round(cotizacionOficial*100)/100;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double valorMoneda(){
        return this.getPrice() *this.cantidad;
    }

    @Override
    public String toString(){
        return "ID: "+id+"\tRank: "+rank+"\tSymbol: "+symbol
                +"\tPrice: "+ getPrice();
    }
}
