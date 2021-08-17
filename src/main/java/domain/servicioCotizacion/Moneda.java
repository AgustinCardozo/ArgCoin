package domain.servicioCotizacion;

public class Moneda {
    private int id;
    private String fecha;

    public int getId() {
        return id;
    }
    private String compra;
    private String venta;
    private int cantidad;

    public Moneda(){ }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Moneda(int id, String fecha, String compra, String venta, int cantidad){
        this.id = id;
        this.fecha = fecha;
        this.compra = compra;
        this.venta = venta;
        this.cantidad = cantidad;
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

    public double valorMoneda(){
        return this.getCompra()*this.cantidad;
    }
    public String toString(){
        return "Cotizacion dolar oficial\n\n" + "Fecha: "+fecha+"\nDolar venta: "+venta
                +"\tDolar compra: "+compra;
    }

}
