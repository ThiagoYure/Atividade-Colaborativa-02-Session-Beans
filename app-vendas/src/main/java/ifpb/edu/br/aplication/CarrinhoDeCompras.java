package ifpb.edu.br.aplication;


import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Produto.Produto;

import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
public class CarrinhoDeCompras {

    private final Venda venda = new Venda();

    public void adicionar(Produto produto) {
        this.venda.adicionar(produto);
    }

    public void incrementar(Produto produto) {
        this.venda.incrementar(produto);
    }

    public void decrementar(Produto produto) {
        this.venda.decrementar(produto);
    }

    public void remover(Produto produto) {
        this.venda.remover(produto);
    }

    public List<Item> itens() {
        return this.venda.itens();
    }

    @Remove
    public void finalizar(Cliente cliente) {
        this.venda.finalizar(cliente);
    }
}
