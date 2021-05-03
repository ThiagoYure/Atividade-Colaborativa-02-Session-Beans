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
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorCarrinhoDeCompras implements Serializable {

    @EJB
    private CarrinhoDeCompras carrinho;
    private Cliente cliente = new Cliente();

    public String novo(Produto produto) {
        this.carrinho.adicionar(
                produto
        );
        return null;
    }

    public String remover(Produto produto) {
        this.carrinho.remover(produto);
        return null;
    }

    public List<Item> todosOsProdutos() {
        return this.carrinho.itens();
    }

    public String checkout() {
        this.carrinho.finalizar(this.cliente);
        NovaInstanciaCarrinho();
        return null;
    }

    private void NovaInstanciaCarrinho() {
        this.carrinho = CDI.current()
                .select(CarrinhoDeCompras.class)
                .get();
    }

    public String incrementar(Produto produto) {
        this.carrinho.incrementar(produto);
        return null;
    }

    public String decrementar(Produto produto) {
        this.carrinho.decrementar(produto);
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
