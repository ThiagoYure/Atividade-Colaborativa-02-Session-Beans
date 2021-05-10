package ifpb.edu.br.web;

import ifpb.edu.br.aplication.CarrinhoDeCompras;
import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Item.Item;
import ifpb.edu.br.domain.Produto.Produto;
import ifpb.edu.br.domain.Produto.ProdutoService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorCarrinhoDeCompras implements Serializable {

    @EJB
    private CarrinhoDeCompras carrinho;
    private Cliente cliente = new Cliente();
    private List<Produto> produtos = new ArrayList<>();

    public String novo() {
        this.cliente.setId(1);
        this.carrinho.adicionar( calcularVenda(), this.cliente.getId());
        return null;
    }

    public String remover(Produto produto) {
        this.carrinho.remover(produto);
        return null;
    }

    public List<Produto> todosOsProdutos() {
        return produtos;
    }

    public String checkout() {
        try {
            this.carrinho.adicionar(calcularVenda(), 1);
            this.carrinho.finalizar(produtos);
            NovaInstanciaCarrinho();
        }
        catch (NullPointerException error){
            System.out.println(error);
        }
        return null;
    }

    private void NovaInstanciaCarrinho() {
        this.carrinho = CDI.current()
                .select(CarrinhoDeCompras.class)
                .get();
        produtos = new ArrayList<>();
    }

    public String incrementar(Produto produto) {
        produtos.add(produto);
        return null;
    }

    public String decrementar(Produto produto) {
        produtos.remove(produto);
        return null;
    }
    
    public BigDecimal calcularVenda(){
        double valor = 0.0;
        for (Produto produto: produtos) {
            valor= valor + produto.getValor().doubleValue();
        }
        return BigDecimal.valueOf(valor);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
