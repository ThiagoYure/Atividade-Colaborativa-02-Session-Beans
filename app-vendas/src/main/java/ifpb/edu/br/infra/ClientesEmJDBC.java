package ifpb.edu.br.infra;


import ifpb.edu.br.domain.Cliente.Cliente;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class ClientesEmJDBC {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;

    public void criar(Cliente novo){
        String query = "INSERT INTO cliente (nome, cpf)" + "VALUES (?, ?)";
        try {
            PreparedStatement statement = this.dataSource.getConnection().prepareStatement(query);
            statement.setString(1, novo.getNome());
            statement.setString(2, novo.getCpf());

            statement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Cliente> listarTodos(){
        String query = "SELECT * FROM cliente";
        PreparedStatement statement = null;
        try {
            statement = this.dataSource.getConnection().prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Cliente> clientes = new ArrayList<Cliente>();
            Cliente cliente = null;
            while (result.next()) {
                cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setNome(result.getString("nome"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void atualizar(Cliente novo){
        String sql = "UPDATE cliente SET nome = ? , cpf = ? WHERE id = ?";

        PreparedStatement statement = null;
        try {
            statement = this.dataSource.getConnection().prepareStatement(sql);
            statement.setString(1, novo.getNome());
            statement.setString(2, novo.getCpf());
            statement.setInt(3, novo.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void excluir(Cliente cliente){
        String sql = "DELETE FROM cliente WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = this.dataSource.getConnection().prepareStatement(sql);
            statement.setInt(1, cliente.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Cliente buscaPorId(int id){
        String query = "SELECT * FROM cliente WHERE id = ?";
        PreparedStatement statement = null;
        try {
            statement = this.dataSource.getConnection().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Cliente cliente = null;
            if (result.next()) {
                cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setCpf(result.getString("cpf"));
                cliente.setNome(result.getString("nome"));
                return cliente;
            }
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
