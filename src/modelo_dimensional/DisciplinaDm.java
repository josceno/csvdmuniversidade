package modelo_dimensional;

import modelo_relacional.Aluno;
import modelo_relacional.Curriculo;
import modelo_relacional.Diciplina;
import modelo_relacional.HistoricosEscolares;
import repositorio.Repositorio;

import java.util.Objects;

public class DisciplinaDm {
    private int codigoDisciplina;
    private boolean extra;
    private String nomeDisciplina;
    private double reprovacaopctg;
    Repositorio repositorio;
    private Aluno aluno;
    public DisciplinaDm(int codigoDisciplina,
     String nomeDisciplina, Aluno aluno) {
        this.codigoDisciplina = codigoDisciplina;
        this.extra = isExtra();
        this.reprovacaopctg = calcReprovacao();
        this.nomeDisciplina = nomeDisciplina;
        this.aluno = aluno;

    }
     private boolean isExtra(){
         for (HistoricosEscolares h: repositorio.historcosEscolares()) {
             if(h.getDiciplina().getCodigoDisciplina() == codigoDisciplina && aluno.getMatricula() == h.getAluno().getMatricula()){
                 for (Curriculo c: repositorio.curriculos()) {
                     if(c.getCodDiciplina().getCodigoDisciplina() == codigoDisciplina && c.getCodCurso().getCodigoCurso() == h.getAluno().getCodigoCurso().getCodigoCurso()){
                         return true;
                     }
                 }
             }
         }

        return  false;
     }
     private double calcReprovacao(){
        int total = 0;
        int repovado = 0;
         for (HistoricosEscolares h: repositorio.historcosEscolares()) {
             if(h.getDiciplina().getCodigoDisciplina() == codigoDisciplina){
                 ++total;
                if( h.getSituacao().equals("RM")){
                    ++repovado;
                 }
             }
         }
         return  repovado/total * 100;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DisciplinaDm that)) return false;
        return codigoDisciplina == that.codigoDisciplina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoDisciplina);
    }

    @Override
    public String toString() {
        return "DisciplinaDm{" +
                "codigoDisciplina=" + codigoDisciplina +
                ", extra=" + extra +
                ", nomeDisciplina='" + nomeDisciplina + '\'' +
                ", reprovacaopctg=" + reprovacaopctg +
                ", repositorio=" + repositorio +
                '}';
    }
}
