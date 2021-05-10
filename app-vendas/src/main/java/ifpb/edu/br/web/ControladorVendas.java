package ifpb.edu.br.web;

import ifpb.edu.br.domain.Item.Item;
import ifpb.edu.br.domain.Item.ItemService;
import ifpb.edu.br.domain.Venda.Venda;
import ifpb.edu.br.domain.Venda.VendaService;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.util.List;


@Named
@SessionScoped
public class ControladorVendas {
    @EJB
    private VendaService vendaService;
    private ItemService itemService;
    private Venda venda = new Venda();
    private Item item = new Item();

    public String novoVenda(int productId, int quantidate){
        System.out.println(venda.toString());
        item.setVendaId(venda.getId());
        item.setQunatidade(quantidate);
        item.setProdutoId(productId);
        itemService.novoItem(item);
        vendaService.novaVenda(venda);
        return null;
    }

    public List<Venda> listar(int cliente){
        System.out.println("meus pedidos: " + vendaService.listarPedido(cliente));
        return vendaService.listarPedido(cliente);
    }

    public String excluir(Venda venda){
        vendaService.removerVenda(venda);
        this.venda = new Venda();
        return null;
    }

    public String atualizar(){
        vendaService.atualizarProduto(venda);
        this.venda = new Venda();
        return null;
    }

    public String atualizarProdutoLocal(Venda venda){
        this.venda = venda;
        return "atualizacao_produto.xhtml?faces-redirect=true";
    }
}
