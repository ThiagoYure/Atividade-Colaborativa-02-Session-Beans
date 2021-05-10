package ifpb.edu.br.infra;

import ifpb.edu.br.domain.Item.Item;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Local
@Stateless
public class ItemJDBC {
    @Resource(lookup = "java:app/jdbc/pgadmin")
    private DataSource dataSource;

    public void criar(Item novo) throws SQLException {
        String query = "INSERT INTO item (vendaId, produtoId, quantidade) VALUES (?, ?, ?)";
        Connection con = this.dataSource.getConnection();
        System.out.println(con);
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setInt(1, novo.getVendaId());
            statement.setInt(2, novo.getProdutoId());
            statement.setInt(3, novo.getQunatidade());
            statement.executeUpdate();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Item> listarTodos(){
        String query = "SELECT * FROM item ORDER BY id_venda";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            List<Item> items = new ArrayList<Item>();
            Item item = null;
            while (result.next()) {
                item = new Item();
                item.setVendaId(result.getInt("id_venda"));
                item.setProdutoId(result.getInt("id_produto"));
                item.setQunatidade(result.getInt("quantidade"));
                items.add(item);
            }
            con.close();
            return items;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void atualizar(Item novo){
        String sql = "UPDATE item SET id_venda = ? , id_produto = ? , quantidade = ? WHERE id_venda = ? and id_produto = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, novo.getVendaId());
            statement.setInt(2, novo.getProdutoId());
            statement.setInt(3, novo.getQunatidade());
            statement.setInt(4, novo.getVendaId());
            statement.setInt(5, novo.getProdutoId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void excluir(Item item){
        String sql = "DELETE FROM item WHERE id_venda = ? and id_produto = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(sql);
            statement.setInt(1, item.getVendaId());
            statement.setInt(2, item.getProdutoId());
            statement.executeUpdate();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Item buscaPorId(int idVenda, int idProduto){
        String query = "SELECT * FROM item WHERE id_venda = ? and id_produto = ?";
        PreparedStatement statement = null;
        try {
            Connection con = this.dataSource.getConnection();
            statement = con.prepareStatement(query);
            statement.setInt(1, idVenda);
            statement.setInt(2, idProduto);
            ResultSet result = statement.executeQuery();
            Item item = null;
            if (result.next()) {
                item = new Item();
                item.setVendaId(result.getInt("id_venda"));
                item.setProdutoId(result.getInt("id_produto"));
                item.setQunatidade(result.getInt("quantidade"));
                con.close();
                return item;
            }
            con.close();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}