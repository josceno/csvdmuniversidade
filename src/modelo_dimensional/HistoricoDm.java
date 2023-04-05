package modelo_dimensional;

import modelo_relacional.Aluno;
import modelo_relacional.TurmasMatricula;
import repositorio.Repositorio;

import java.util.Objects;

public class HistoricoDm {
    private int codigoHistorico;
    private int faltas;
    private  double nota1;
    private double nota2;
    private double nota3;
    private double nota4;
    private String situacao;
    private Aluno aluno;

    Repositorio repositorio;

    public HistoricoDm(Repositorio repositorio,String situacao,Aluno aluno) {
        this.repositorio = repositorio;
        this.aluno = aluno;
        setSituacao(situacao);
        popularNotas();
    }
    public HistoricoDm(int codigoHistorico, Repositorio repositorio,String situacao,Aluno aluno) {
        this.codigoHistorico = codigoHistorico;
        this.repositorio = repositorio;
        this.aluno = aluno;
        setSituacao(situacao);
        popularNotas();
    }

    private void setSituacao(String situacao) {
        
       if(situacao.equals("AP")){
        this.situacao = "APROVADO";
       }
       if(situacao.equals("RM")){
        this.situacao = "REPROVADO";
       }

    }

    public void popularNotas(){
        for (TurmasMatricula turmas:repositorio.turmasMatriculadas()) {
            if(turmas.getAluno().getMatricula() == aluno.getMatricula()){
                nota1 = turmas.getNota1();
                nota2 = turmas.getNota2();
                nota3 = turmas.getNota3();
                nota4 = turmas.getNota4();
            }
        }
    }
    
    public int getCodigoHistorico() {
        return codigoHistorico;
    }
    public int getFaltas() {
        return faltas;
    }
    public double getNota1() {
        return nota1;
    }
    public double getNota2() {
        return nota2;
    }
    public double getNota3() {
        return nota3;
    }
    public double getNota4() {
        return nota4;
    }
    public String getSituacao() {
        return situacao;
    }
    public Aluno getAluno() {
        return aluno;
    }
    public Repositorio getRepositorio() {
        return repositorio;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HistoricoDm that)) return false;
        return codigoHistorico == that.codigoHistorico;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoHistorico);
    }


}
