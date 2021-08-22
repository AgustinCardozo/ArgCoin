package domain.cliente;


public class ClienteMapper {
    private int dni;
    private String nombre;
    private String apellido;
    private String  mail;
    private String direccion;

    public ClienteMapper(int dni, String nombre, String apellido,String mail,String direccion) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.direccion = direccion;
    }

    public int insert() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.insert(this.dni,this.nombre,this.apellido,this.mail,this.direccion);
    }
}
