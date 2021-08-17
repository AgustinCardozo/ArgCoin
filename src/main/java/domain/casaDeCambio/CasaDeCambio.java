package domain.casaDeCambio;

import domain.billetera.*;
import domain.cliente.*;
import domain.servicioCotizacion.*;
import java.util.List;


//Hacerlo singleton?
public class CasaDeCambio {
    private  int id;
    private String nombre;
    private String mail;
    private String direccion;
    private BilleteraVirtual billetera;
    private List<Cliente> clientes;
    private List<Moneda> monedas;
    private List<Cliente> suscriptores;
}
