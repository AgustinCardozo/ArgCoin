package domain.billetera;

import domain.cliente.Cliente;

public class BilleteraMapper {
    int iddni;

    public BilleteraMapper(int iddni){
        this.iddni=iddni;
        }

        public int insert() {
            BilleteraDAO billeteraDAO = new BilleteraDAO();
            return billeteraDAO.insert(this.iddni);
        }
}
