package ifpb.edu.br.domain.Produto;

import ifpb.edu.br.domain.Cliente.Cliente;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ProdutoService {

    @EJB
    private ProdutoService produtos;

    public void novoProduto(Produto novo){

    }

    public void removerProduto(Produto novo){

    }

    public List<Produto> listarTodos(){
        return null;
    }

    public Produto listarPorId(int id){
        return null;
    }

    public void atualizarProduto(Produto novo){

    }
}
