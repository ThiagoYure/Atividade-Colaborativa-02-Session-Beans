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
import java.util.List;

@Named
@SessionScoped
public class ControladorProduto implements Serializable {

    @EJB
    private ProdutoService produtoService;
    private Produto produto;
    private List<Produto> produtos;
}
