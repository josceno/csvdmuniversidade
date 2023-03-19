package model;

import java.util.Objects;

public class Diciplina {
    private int codigoDisciplina;
    private int quantidade;
    private String nomeDisciplina;
    private  Diciplina equivalente;

    public Diciplina(int codigoDisciplina, int quantidade, String nomeDisciplina, Diciplina equivalente) {
        this.codigoDisciplina = codigoDisciplina;
        this.quantidade = quantidade;
        this.nomeDisciplina = nomeDisciplina;
        this.equivalente = equivalente;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public Diciplina getEquivalente() {
        return equivalente;
    }

    public void setEquivalente(Diciplina equivalente) {
        this.equivalente = equivalente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diciplina diciplina)) return false;
        return codigoDisciplina == diciplina.codigoDisciplina && Objects.equals(nomeDisciplina, diciplina.nomeDisciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDisciplina, nomeDisciplina);
    }

    @Override
    public String toString() {
        return "Diciplina{" +
                "codigoDisciplina=" + codigoDisciplina +
                ", quantidade=" + quantidade +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", equivalente=" + equivalente +
                '}';
    }
}
