package ifpb.edu.br.domain.Produto;

import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.infra.ProdutosEmJDBC;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProdutoService {

    @EJB
    private ProdutosEmJDBC produtos;

    public void novoProduto(Produto novo){
        if (novo == null) {
            System.out.println("Cliente nulo");
            return;
        }
        System.out.println(novo.valido());
        if (novo.valido()) {
            produtos.criar(novo);
        }
    }

    public void removerProduto(Produto produto){
        if (produto == null) {
            System.out.println("Produto nulo");
            return;
        }
        if (produto.valido()) {
            produtos.excluir(produto);
        }
    }

    public List<Produto> listarTodos(){
        return produtos.listarTodos();
    }

    public Produto listarPorId(int id){
        return produtos.buscaPorId(id);
    }

    public Produto listarPorDescricao(String descricao){
        return produtos.buscaPorDescricao(descricao);
    }

    public void atualizarProduto(Produto novo){
        if (novo == null) {
            System.out.println("Cliente nulo");
            return;
        }
        if (novo.valido()) {
            produtos.atualizar(novo);
        }
    }
}
