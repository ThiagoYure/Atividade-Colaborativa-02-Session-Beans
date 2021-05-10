package ifpb.edu.br.domain.Venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Venda implements Serializable {
    private int id;
    private int cliente;
    private BigDecimal valor;

    public Venda() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id == venda.id && cliente == venda.cliente && Objects.equals(valor, venda.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, valor);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", valor=" + valor +
                '}';
    }
}
