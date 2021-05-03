package ifpb.edu.br.domain.Produto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Produto implements Serializable {
    private int id;
    private String descricao;
    private BigDecimal valor;

    public Produto() {
    }

    public Produto(String descricao, BigDecimal valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public Produto(int id, String descricao, BigDecimal valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return getId() == produto.getId() && Objects.equals(getDescricao(), produto.getDescricao()) && Objects.equals(getValor(), produto.getValor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescricao(), getValor());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }

    public boolean valido(){
        return !"".equals(this.descricao.trim());
    }
}
