package domain.servicioCotizacion;

public class Moneda {
    private String fecha;
    private String compra;
    private String venta;

    public Moneda(){ }

    public Moneda(String fecha, String compra, String venta){
        this.fecha = fecha;
        this.compra = compra;
        this.venta = venta;
    }

    public String getFecha() {
        return fecha;
    }

    public double getCompra(){
        return Double.parseDouble(compra);
    }
    public double getVenta(){
        return Double.parseDouble(venta);
    }

    public String toString(){
        return "Cotizacion dolar oficial\n\n" + "Fecha: "+fecha+"\nDolar venta: "+venta
                +"\tDolar compra: "+compra;
    }
}