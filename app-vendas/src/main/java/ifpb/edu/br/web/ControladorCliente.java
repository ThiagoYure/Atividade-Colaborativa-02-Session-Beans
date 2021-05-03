package ifpb.edu.br.web;


import ifpb.edu.br.domain.Cliente.Cliente;
import ifpb.edu.br.domain.Cliente.ClienteService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class ControladorCliente implements Serializable {

    @EJB
    private ClienteService clienteService;
    private Cliente cliente = new Cliente();

    public String novoCliente(){
        System.out.println(cliente.toString());
        clienteService.novoCliente(cliente);
        return null;
    }

    public List<Cliente> listarTodos(){
        return clienteService.listarTodos();
    }

    public String excluir(Cliente cliente){
        clienteService.removerCliente(cliente);
        this.cliente = new Cliente();
        return null;
    }

    public String atualizar(){
        clienteService.atualizarCliente(cliente);
        cliente = new Cliente();
        return null;
    }

    public String atualizarClienteLocal(Cliente cliente){
        this.cliente = cliente;
        return "atualizacao_cliente.xhtml?faces-redirect=true";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
