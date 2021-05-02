package ifpb.edu.br.api;


import ifpb.edu.br.domain.Produto.Produto;
import ifpb.edu.br.domain.Produto.ProdutoService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("produtos")
@Stateless
public class ProdutosResource {

    @EJB
    private ProdutoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{descricao}")
    public Produto buscaPorDescricao(@PathParam("descricao") String descricao){
        return service.listarPorDescricao(descricao);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listarTodos(){
        return service.listarTodos();
    }

}
