package ifpb.edu.br.infra;

import ifpb.edu.br.domain.Venda.Venda;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class VendasJDBC {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;

    public void criar(Venda novo){

        String query = "INSERT INTO Venda (total, id_cliente) VALUES (?, ?)";
        try {
            Connection con = this.dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setBigDecimal(1, novo.getValor());
            statement.setInt(2, novo.getCliente());
            statement.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Venda> listarTodos(){
        String query = "SELECT * FROM Venda ORDER BY total";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Venda> vendas = new ArrayList<Venda>();
            Venda venda = null;
            while (result.next()) {
                venda = new Venda();
                venda.setId(result.getInt("id"));
                venda.setCliente(result.getInt("id_cliente"));
                venda.setValor(BigDecimal.valueOf(result.getFloat("total")));
                vendas.add(venda);
            }
            con.close();
            return vendas;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void atualizar(Venda novo){
        String sql = "UPDATE Venda SET total = ? , id_cliente = ? WHERE id = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setFloat(1, novo.getValor().floatValue());
            statement.setInt(2, novo.getCliente());
            statement.setInt(3, novo.getId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void excluir(Venda venda){
        String sql = "DELETE FROM Venda WHERE id = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, venda.getId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Venda buscaPorId(int id){
        String query = "SELECT * FROM Venda WHERE id = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Venda venda = null;
            if (result.next()) {
                venda = new Venda();
                venda.setId(result.getInt("id"));
                venda.setValor(BigDecimal.valueOf(result.getFloat("total")));
                venda.setCliente(result.getInt("id_cliente"));
                con.close();
                return venda;
            }
            con.close();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
