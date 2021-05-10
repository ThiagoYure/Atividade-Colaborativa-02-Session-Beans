package ifpb.edu.br.aplication;


import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Item.Item;
import ifpb.edu.br.domain.Item.ItemService;
import ifpb.edu.br.domain.Produto.Produto;
import ifpb.edu.br.domain.Venda.Venda;
import ifpb.edu.br.domain.Venda.VendaService;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.math.BigDecimal;
import java.util.List;

@Stateful
public class CarrinhoDeCompras {

    private final Venda venda = new Venda();
    private VendaService vendaService = new VendaService();
    private ItemService itemService = new ItemService();

    public void adicionar(BigDecimal valor, int clienteId) {
        this.venda.setCliente(clienteId);
        this.venda.setValor(valor);
    }

    public void remover(Produto produto) {
        //this.venda.remover(produto);
    }

    public List<Item> itens() {
        //return this.venda.itens();
        return null;
    }

    @Remove
    public void finalizar(List<Produto> produtos) {
       if (!(venda == null && produtos.size()==0)){
           vendaService.novaVenda(venda);
           for (Produto produto: produtos) {
               itemService.novoItem(new Item(venda.getId(), produto.getId(), 1));
           }
       } else {
           System.out.println("Venda Nula");
       }
    }
}
