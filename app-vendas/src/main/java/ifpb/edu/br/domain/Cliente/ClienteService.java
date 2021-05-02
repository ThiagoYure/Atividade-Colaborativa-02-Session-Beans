package ifpb.edu.br.domain.Cliente;

import ifpb.edu.br.infra.ClientesEmJDBC;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class ClienteService {

    @EJB
    private ClientesEmJDBC clientes;

    public void novoCliente(Cliente novo){
        if (novo == null) {
            System.out.println("Cliente nulo");
            return;
        }
        if (novo.valido()) {
            clientes.criar(novo);
        }
    }

    public void removerCliente(Cliente cliente){
        if (cliente == null) {
            System.out.println("Cliente nulo");
            return;
        }
        if (cliente.valido()) {
            clientes.excluir(cliente);
        }
    }

    public List<Cliente> listarTodos(){
        return clientes.listarTodos();
    }

    public Cliente listarPorId(int id){
        return clientes.buscaPorId(id);
    }

    public void atualizarCliente(Cliente novo){
        if (novo == null) {
            System.out.println("Cliente nulo");
            return;
        }
        if (novo.valido()) {
            clientes.atualizar(novo);
        }
    }
}
