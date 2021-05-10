package ifpb.edu.br.domain.Item;

import ifpb.edu.br.infra.ItemJDBC;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.sql.SQLException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Stateless
public class ItemService {

    @EJB
    private ItemJDBC itemJDBC = new ItemJDBC();

    public void novoItem(Item novo){
        if (novo == null) {
            System.out.println("Item nulo");
            return;
        }
        System.out.println(novo.toString());
        try {
            itemJDBC.criar(novo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void removerItem(Item item){
        if (item == null) {
            System.out.println("Item nulo");
            return;
        }
        itemJDBC.excluir(item);
    }

    public List<Item> listarTodos(){
        return itemJDBC.listarTodos();
    }

    public Item listarPorId(int idVenda, int idproduto){
        return itemJDBC.buscaPorId(idVenda, idproduto);
    }

    public void atualizarProduto(Item novo){
        if (novo == null) {
            System.out.println("Item nulo");
            return;
        }
            itemJDBC.atualizar(novo);
    }
    public List<Item> listarPedido(int idVenda){
        List<Item> allOrder = itemJDBC.listarTodos();
        List<Item> myOrder = filter(order -> order.getVendaId() == idVenda, allOrder);
        return myOrder;
    }

    private List<Item> filter(Predicate<Item> criteria, List<Item> list) {
        return list.stream().filter(criteria).collect(Collectors.<Item>toList());
    }
}
