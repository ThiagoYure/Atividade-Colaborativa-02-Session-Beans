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

    public String novoProduto(){
        System.out.println(produto.toString());
        produtoService.novoProduto(produto);
        return null;
    }

    public List<Produto> listarTodos(){
        return produtoService.listarTodos();
    }

    public String excluir(Produto produto){
        produtoService.removerProduto(produto);
        this.produto = new Produto();
        return null;
    }

    public String atualizar(){
        produtoService.atualizarProduto(produto);
        this.produto = new Produto();
        return null;
    }

    public String atualizarProdutoLocal(Produto produto){
        this.produto = produto;
        return "atualizacao_produto.xhtml?faces-redirect=true";
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
