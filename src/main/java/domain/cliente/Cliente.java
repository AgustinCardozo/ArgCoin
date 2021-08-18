package domain.cliente;

import domain.billetera.BilleteraVirtual;
import domain.excepcion.ReferidoExcepcion;
import domain.servicioCotizacion.*;
import domain.excepcion.MontoInsuficienteException;
import java.util.ArrayList;
import java.util.List;


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

    public double calcularPuntosArgCoin(){
        return this.billetera.saldoTotal() * PROPORCION_PUNTOS_ARGCOIN;
    }

    public double getCantidadPesos() {
        return cantidadPesos;
    }

    public void comprarMoneda(Moneda moneda) throws MontoInsuficienteException {
        if(moneda.valorMoneda()<=this.getCantidadPesos()){
            this.setCantidadPesos(this.getCantidadPesos() - moneda.getCompra());
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
    public Cliente(int id, String nombre, String apellido, String mail, String direccion) {
        this.dni = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
    }

    public String getMail() {
        return mail;
    }
}

