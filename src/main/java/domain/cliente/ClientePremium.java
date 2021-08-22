package domain.cliente;

import domain.excepcion.ReferidoExcepcion;
import domain.formaDePago.FormaDePago;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClientePremium extends Cliente {
    private List<Cliente> referidos =new ArrayList<>();

    public ClientePremium(int id, String nombre, String apellido, String mail, String direccion, FormaDePago formaDePago) throws IOException {
        super(id, nombre, apellido, mail, direccion, formaDePago);
    }



    public double puntosReferidos(){
        return this.referidos.stream().mapToDouble(Cliente::calcularPuntosArgCoin).sum();
    }
    public void agregarReferido(Cliente cliente) throws ReferidoExcepcion {
        if(cliente.agregarReferido(this)==false)
            referidos.add(cliente);
        else
            System.out.println("Ya tiene asociado otro usuario");
    }
    @Override
    public double calcularPuntosArgCoin() {
        return puntosReferidos();
    }
}

