package ifpb.edu.br.infra;


import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Produto.Produto;

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
public class ProdutosEmJDBC {

    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;

    public void criar(Produto novo){
        String query = "INSERT INTO produto (descricao, valor) VALUES (?, ?)";
        try {
            Connection con = this.dataSource.getConnection();
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, novo.getDescricao());
            statement.setFloat(2, novo.getValor().floatValue());

            statement.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Produto> listarTodos(){
        String query = "SELECT * FROM produto ORDER BY descricao";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Produto> produtos = new ArrayList<Produto>();
            Produto produto = null;
            while (result.next()) {
                produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setDescricao(result.getString("descricao"));
                produto.setValor(BigDecimal.valueOf(result.getFloat("valor")));
                produtos.add(produto);
            }
            con.close();
            return produtos;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void atualizar(Produto novo){
        String sql = "UPDATE produto SET descricao = ? , valor = ? WHERE id = ?";

        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setString(1, novo.getDescricao());
            statement.setFloat(2, novo.getValor().floatValue());
            statement.setInt(3, novo.getId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void excluir(Produto produto){
        String sql = "DELETE FROM produto WHERE id = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, produto.getId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Produto buscaPorId(int id){
        String query = "SELECT * FROM produto WHERE id = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            Produto produto = null;
            if (result.next()) {
                produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setDescricao(result.getString("descricao"));
                produto.setValor(BigDecimal.valueOf(result.getFloat("valor")));
                con.close();
                return produto;
            }
            con.close();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public Produto buscaPorDescricao(String descricao){
        String query = "SELECT * FROM produto WHERE descricao = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            statement.setString(1, descricao);
            ResultSet result = statement.executeQuery();
            Produto produto = null;
            if (result.next()) {
                produto = new Produto();
                produto.setId(result.getInt("id"));
                produto.setDescricao(result.getString("descricao"));
                produto.setValor(BigDecimal.valueOf(result.getFloat("valor")));
                con.close();
                return produto;
            }
            con.close();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
