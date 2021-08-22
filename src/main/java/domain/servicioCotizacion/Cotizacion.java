package domain.servicioCotizacion;

public class Cotizacion {
    private int id;
    private String fecha;

    /*public int getId() {
        return id;
    }*/
    private String compra;
    private String venta;

    public int getId() {
        return id;
    }

    private int cantidad;

    public Cotizacion(){ }

    /*public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }*/

    public Cotizacion(int id, String fecha, String compra, String venta){
        this.id = id;
        this.fecha = fecha;
        this.compra = compra;
        this.venta = venta;
        //this.cantidad = cantidad;
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

    /*public double valorMoneda(){
        return this.getCompra()*this.cantidad;
    }*/

    public String toString(){
        return "Cotizacion dolar oficial\n\n" + "Fecha: "+fecha+"\nDolar venta: "+venta
                +"\tDolar compra: "+compra;
    }

}
