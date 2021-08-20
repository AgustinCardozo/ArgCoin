package domain.cliente;

import domain.billetera.BilleteraVirtual;
import domain.excepcion.ReferidoExcepcion;
import domain.servicioCotizacion.*;
import domain.excepcion.MontoInsuficienteException;
import domain.servicioCriptomoneda.Criptomoneda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Cliente {
    private int dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String direccion;
    public BilleteraVirtual billetera =new BilleteraVirtual();
    private double cantidadPesos;
    private ClientePremium referido;
    private List<Tarjeta> tarjetas = new ArrayList<>();
    static final float PROPORCION_PUNTOS_ARGCOIN = 0.001f;
    private double topeDeVenta;

    public double calcularPuntosArgCoin(){
        return this.billetera.saldoTotal() * PROPORCION_PUNTOS_ARGCOIN;
    }

    public double getCantidadPesos() {
        return cantidadPesos;
    }

    public void comprarMoneda(Criptomoneda moneda) throws MontoInsuficienteException, IOException {

        if(moneda.valorMoneda()<=this.getCantidadPesos()){
            this.setCantidadPesos(this.getCantidadPesos() - moneda.getPrice());
            this.billetera.adquirirMoneda(moneda);
        }else{
            throw new MontoInsuficienteException();
        }
    }

    public void setCantidadPesos(double cantidadPesos) {
        this.cantidadPesos = cantidadPesos;
    }

    public boolean agregarReferido(ClientePremium clientePremium) throws ReferidoExcepcion {
        if(this.referido==null) {
            this.referido = clientePremium;
            return false;
        }else{
            throw new ReferidoExcepcion();
        }
    }
    public Cliente(int id, String nombre, String apellido, String mail, String direccion) throws IOException {
        this.dni = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }

    public double consultarCotizacion(Criptomoneda criptomoneda) throws IOException {
        return getCriptomoneda(criptomoneda).consultarContizacionEnPesos();
    }

    public Criptomoneda getCriptomoneda(Criptomoneda criptomoneda){
        return billetera.getCriptomonedas().stream().filter(cripto -> cripto == criptomoneda).collect(Collectors.toList()).get(0);
    }

    public double getTopeDeVenta() {
        return topeDeVenta;
    }

    public BilleteraVirtual getBilletera() {
        return billetera;
    }
}

