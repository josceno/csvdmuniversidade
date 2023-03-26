package modelo_relacional;

import java.sql.Date;


public class Aluno {
    private int matricula;
    private Curso codigoCurso;
    private Date datanascimento;
    private int totalCredito;
    private double mgp;
    private String nomeAluno;
    private String email;

    public Aluno(int matricula, Curso codigoCurso, Date datanascimento, int totalCredito, double mgp, String nomeAluno, String email) {
        this.matricula = matricula;
        this.codigoCurso = codigoCurso;
        this.datanascimento = datanascimento;
        this.totalCredito = totalCredito;
        this.mgp = mgp;
        this.nomeAluno = nomeAluno;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Curso getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Curso codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
    }

    public int getTotalCredito() {
        return totalCredito;
    }

    public void setTotalCredito(int totalCredito) {
        this.totalCredito = totalCredito;
    }

    public double getMgp() {
        return mgp;
    }

    public void setMgp(double mgp) {
        this.mgp = mgp;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", codigoCurso=" + codigoCurso.getCodigoCurso() +
                ", datanascimento=" + datanascimento +
                ", totalCredito=" + totalCredito +
                ", mgp=" + mgp +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
