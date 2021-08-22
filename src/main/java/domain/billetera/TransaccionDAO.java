package domain.billetera;

import java.sql.*;

public class TransaccionDAO {
    private Connection conn;

    public Connection newConnection() {
        Connection conn = null;

        try {
            String connectionUrl = "jdbc:mysql://localhost:3308/argcoin";
            conn = DriverManager.getConnection(connectionUrl, "root", "");
            System.out.println("Conexion realizada");
            return conn;
        } catch (SQLException var3) {
            System.out.println("SQLException: " + var3.getMessage());
            System.out.println("SQLState: " + var3.getSQLState());
            System.out.println("VendorError: " + var3.getErrorCode());
            return null;
        }
    }

    public int insert(int idOrigen, int idDestino, double cotizacion, double cantidad) {
        String consulta = "INSERT INTO cliente (idOrigen, idDestino, cotizacion, cantidad) VALUES ('"+ idOrigen +"' ,'"+ idDestino +"','" + cotizacion +"','"+ cantidad +"');";

        try {
            this.conn = this.newConnection();
            PreparedStatement stmt = this.conn.prepareStatement(consulta, 1);
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            return generatedKeys.next() ? generatedKeys.getInt(1) : 0;
        } catch (SQLException var6) {
            System.out.println("Error en Insert");
            return 0;
        }
    }

}