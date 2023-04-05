package modelo_dimensional;

import modelo_relacional.Aluno;
import modelo_relacional.Curso;
import modelo_relacional.HistoricosEscolares;
import repositorio.PostgresConnection;
import repositorio.Repositorio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AlunoDm {
    private int matricula;
    private Date datanascimento;
    private String nomeAluno;
    private String email;
    private double pctualAprovacao;
    private final Repositorio repositorio = new PostgresConnection();

    public AlunoDm(int matricula, Date datanascimento, String nomeAluno, String email, Repositorio repositorio) {
        this.matricula = matricula;
        this.datanascimento = datanascimento;
        this.nomeAluno = nomeAluno;
        this.email = email;
        this.pctualAprovacao = calpctg();
        //this.repositorio = repositorio;

    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Date getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(Date datanascimento) {
        this.datanascimento = datanascimento;
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

    public Double getPctualAprovacao() {
        return pctualAprovacao;
    }

    public void setPctualAprovacao(Double pctualAprovacao) {
        this.pctualAprovacao = pctualAprovacao;
    }
    public double calpctg(){
        List<Aluno> aprovados = new ArrayList<>();
        List<HistoricosEscolares> historicoAluno = new ArrayList<>();
        double aprovacaoptg=0.0;
        System.out.println(repositorio);
        for (Aluno aluno : repositorio.alunos()) {
            for(int i = 0; i<repositorio.historcosEscolares().size(); i++){
                if(aluno.equals(repositorio.historcosEscolares().get(i).getAluno())) {
                    historicoAluno.add(repositorio.historcosEscolares().get(i));
                    if(repositorio.historcosEscolares().get(i).getSituacao().equals("AP")){
                        aprovados.add(aluno);
                    }
                }
            }
        }
        historicoAluno.forEach(System.out::println);
        aprovados.forEach(System.out::println);
        aprovacaoptg =(aprovados.size()>0) ? (double) aprovados.size()/historicoAluno.size() * 100:0.0;
        return aprovacaoptg;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlunoDm alunoDm)) return false;
        return matricula == alunoDm.matricula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "AlunoDm{" +
                "matricula=" + matricula +
                ", datanascimento=" + datanascimento +
                ", nomeAluno='" + nomeAluno + '\'' +
                ", email='" + email + '\'' +
                ", pctualAprovacao=" + pctualAprovacao +
                '}';
    }
}
