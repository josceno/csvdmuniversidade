package modelo_dimensional;

import modelo_relacional.*;
import repositorio.Repositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDm {
    private int codigoProfessor;
    private String nome;
    private String email;
    private boolean coordenador;
    private double repravacaopctg;

    private Repositorio repositorio;


    public ProfessorDm(int codigoProfessor, String nome, String email,Repositorio repositorio) throws  Exception{
        this.codigoProfessor = codigoProfessor;
        this.nome = nome;
        this.email = email;
        this.repositorio = repositorio;
        repravacaopctg = calcularPctgReprovados();
        coordenador = isCoordenador();
    }

    public int getCodigoProfessor() {
        return codigoProfessor;
    }

    public void setCodigoProfessor(int codigoProfessor) {
        this.codigoProfessor = codigoProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(boolean coordenador) {
        this.coordenador = coordenador;
    }

    public double getReprovacaopctg() {
        return repravacaopctg;
    }

    public void setReprovacaopctg(double repravacaopctg) {
        this.repravacaopctg = repravacaopctg;
    }

    public Professores professor() throws Exception  {
        Professores professor = new Professores();
        try{

            for (Professores p: repositorio.professoresList()) {
                if(this.codigoProfessor == p.getCodigoProfessor()){
                    professor = p;
                    return professor;

                }
            }
            return null;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return professor;
    }
    public boolean isCoordenador() throws Exception{
        for (Turma turma: repositorio.turmas() ) {
            if(professor().getCodigoProfessor() == turma.getProfessor().getCodigoProfessor()){
                return true;
            }
        }
        return false;
    }
    public double calcularPctgReprovados(){
        double procentagem = 0;
        int reprovado = 0;

        try {
            List<HistoricosEscolares> reprovados = new ArrayList<>();
            for (HistoricosEscolares situacoes: repositorio.historcosEscolares()) {
                if(situacoes.getSituacao().equals("AP")){
                   reprovados.add(situacoes);
                }
            }
            reprovados.forEach(System.out::println);
            List<Curriculo> curriculos = new ArrayList<>();
            for (Curriculo grade : repositorio.curriculos()) {

                if(professor().getCodigoCurso().getCodigoCurso() == grade.getCodCurso().getCodigoCurso() && professor().getCodigoProfessor() !=0){
                    curriculos.add(grade);
                }
            }
            for (HistoricosEscolares sitacao: reprovados) {
                for (Curriculo curr: curriculos ) {
                    if(curr.getCodDiciplina().getCodigoDisciplina() ==sitacao.getDiciplina().getCodigoDisciplina()){
                        reprovado++;
                        System.out.println(reprovado);
                    }
                }

            }
            reprovados.forEach(System.out::println);
            procentagem = (double)reprovado/repositorio.historcosEscolares().size() *100;
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
        return procentagem;


    }

    @Override
    public String toString() {
        return "ProfessorDm{" +
                "codigoProfessor=" + codigoProfessor +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", coordenador=" + coordenador +
                ", repravacaopctg=" + repravacaopctg +
                ", repositorio=" + repositorio +
                '}';
    }
}
