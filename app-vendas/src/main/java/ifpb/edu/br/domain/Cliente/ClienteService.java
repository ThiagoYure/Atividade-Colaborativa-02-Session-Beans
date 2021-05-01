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

    }

    public void removerCliente(Cliente novo){

    }

    public List<Cliente> listarTodos(){
        return null;
    }

    public Cliente listarPorId(int id){
        return null;
    }

    public void atualizarCliente(Cliente novo){

    }
}
