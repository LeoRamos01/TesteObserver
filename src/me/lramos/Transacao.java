package me.lramos;

import java.time.LocalDate;
import java.util.Objects;

public class Transacao {

    private Long id;

    private Long idTotal;

    private Double valor;

    private LocalDate data;

    public Transacao(Long id, Long idTotal, Double valor, LocalDate data) {
        this.id = id;
        this.idTotal = idTotal;
        this.valor = valor;
        this.data = data;
    }

    public Long getIdTotal() {
        return idTotal;
    }

    public void setIdTotal(Long idTotal) {
        this.idTotal = idTotal;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idTotal, valor, data);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) &&
                Objects.equals(idTotal, transacao.idTotal) &&
                Objects.equals(valor, transacao.valor) &&
                Objects.equals(data, transacao.data);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", idTotal=" + idTotal +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }

}
