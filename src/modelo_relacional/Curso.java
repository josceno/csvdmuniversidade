package modelo_relacional;

import java.util.Objects;

public class Curso {
    private int codigoCurso;
    private int total_credito;
    private String nome;
    private  Professores codCoord;

    public Curso(int codigoCurso, int total_credito, String nome, Professores codCoord) {
        this.codigoCurso = codigoCurso;
        this.total_credito = total_credito;
        this.nome = nome;
        this.codCoord = codCoord;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getTotal_credito() {
        return total_credito;
    }

    public void setTotal_credito(int total_credito) {
        this.total_credito = total_credito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professores getCodCoord() {
        return codCoord;
    }

    public void setCodCoord(Professores codCoord) {
        this.codCoord = codCoord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curso curso)) return false;
        return codigoCurso == curso.codigoCurso && total_credito == curso.total_credito && Objects.equals(nome, curso.nome) && Objects.equals(codCoord, curso.codCoord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCurso, total_credito, nome, codCoord);
    }

    @Override
    public String toString() {
        return "Curso{" +
                "codigoCurso=" + codigoCurso +
                ", total_credito=" + total_credito +
                ", nome='" + nome + '\'' +
                ", codCoord=" + codCoord.getCodigoProfessor() +
                '}';
    }
}
