package model;

import java.util.Objects;

public class Professores {
    private int codigoProfessor;
    private Curso codigoCurso;
    private String nomeProfessor;
    private  String email;

    public Professores(int codigoProfessor, Curso codigoCurso, String nomeProfessor, String email) {
        this.codigoProfessor = codigoProfessor;
        this.codigoCurso = codigoCurso;
        this.nomeProfessor = nomeProfessor;
        this.email = email;
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professores that)) return false;
        return codigoProfessor == that.codigoProfessor && codigoCurso.equals(that.codigoCurso) && nomeProfessor.equals(that.nomeProfessor) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoProfessor, nomeProfessor);
    }

    @Override
    public String toString() {
        return "Professores{" +
                "codigoProfessor=" + codigoProfessor +
                ", codigoCurso=" + codigoCurso +
                ", nomeProfessor='" + nomeProfessor + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
