package ifpb.edu.br.domain.Item;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private int vendaId;
    private int produtoId;
    private int qunatidade;

    public Item() {}

    public Item(int vendaId, int produtoId, int qunatidade) {
        this.vendaId = vendaId;
        this.produtoId = produtoId;
        this.qunatidade = qunatidade;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQunatidade() {
        return qunatidade;
    }

    public void setQunatidade(int qunatidade) {
        this.qunatidade = qunatidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return vendaId == item.vendaId && produtoId == item.produtoId && qunatidade == item.qunatidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendaId, produtoId, qunatidade);
    }

    @Override
    public String toString() {
        return "Item{" +
                "vendaId=" + vendaId +
                ", produtoId=" + produtoId +
                ", qunatidade=" + qunatidade +
                '}';
    }
}
