package ifpb.edu.br.web;


import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Cliente.ClienteService;
import ifpb.edu.br.domain.Produto.Produto;
import ifpb.edu.br.domain.Produto.ProdutoService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorProduto implements Serializable {

    @EJB
    private ProdutoService produtoService;
    private Produto produto = new Produto();
    private List<Produto> produtos = new ArrayList<Produto>();

    public String novoProduto(){
        produtoService.novoProduto(produto);
        return null;
    }

    public String listarTodos(){
        produtos = produtoService.listarTodos();
        return null;
    }

    public String excluir(){
        produtoService.removerProduto(produto);
        produto = new Produto();
        return null;
    }

    public String atualizar(){
        produtoService.atualizarProduto(produto);
        return null;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
