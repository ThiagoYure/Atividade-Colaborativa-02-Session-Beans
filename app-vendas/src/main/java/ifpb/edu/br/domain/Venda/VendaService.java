package ifpb.edu.br.domain.Venda;

import ifpb.edu.br.infra.VendasJDBC;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Stateless
public class VendaService {

    @EJB
    private VendasJDBC vendasJDBC = new VendasJDBC();

    public void novaVenda(Venda novo){
        if (novo == null) {
            System.out.println("Venda nulo");
            return;
        }
        vendasJDBC.criar(novo);
    }

    public void removerVenda(Venda venda){
        if (venda == null) {
            System.out.println("Venda nulo");
            return;
        }
            vendasJDBC.excluir(venda);
    }

    public List<Venda> listarTodos(){
        return vendasJDBC.listarTodos();
    }

    public Venda listarPorId(int id){
        return vendasJDBC.buscaPorId(id);
    }

    public void atualizarProduto(Venda novo){
        if (novo == null) {
            System.out.println("Venda nulo");
            return;
        }
            vendasJDBC.atualizar(novo);
    }
    public List<Venda> listarPedido(int idCliente){
        List<Venda> allSells = vendasJDBC.listarTodos();
        List<Venda> mySell = filter(sell -> sell.getCliente() == idCliente, allSells);
        return mySell;
    }

    private List<Venda> filter(Predicate<Venda> criteria, List<Venda> list) {
        return list.stream().filter(criteria).collect(Collectors.<Venda>toList());
    }
}
