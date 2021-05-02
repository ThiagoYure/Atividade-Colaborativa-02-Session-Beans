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
    private List<Cliente> clientes = new ArrayList<Cliente>();

    public String novoCliente(){
        clienteService.novoCliente(cliente);
        return null;
    }

    public String listarTodos(){
        clientes = clienteService.listarTodos();
        return null;
    }

    public String excluir(){
        clienteService.removerCliente(cliente);
        cliente = new Cliente();
        return null;
    }

    public String atualizar(){
        clienteService.atualizarCliente(cliente);
        return null;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
