package model;

import java.util.Objects;

public class TurmasMatricula {
     private int ano;
     private int semestre;
     private Diciplina diciplina;
     private  Aluno aluno;
     private  Professores professores;
     private  double nota1;
     private  double nota2;
     private  double nota3;
     private  Integer faltas1;
     private Integer faltas2;
     private  Integer faltas3;

     public TurmasMatricula(int ano, int semestre, Diciplina diciplina, Aluno aluno, Professores professores, double nota1, double nota2, double nota3, Integer faltas1, Integer faltas2, Integer faltas3) {
          this.ano = ano;
          this.semestre = semestre;
          this.diciplina = diciplina;
          this.aluno = aluno;
          this.professores = professores;
          this.nota1 = nota1;
          this.nota2 = nota2;
          this.nota3 = nota3;
          this.faltas1 = faltas1;
          this.faltas2 = faltas2;
          this.faltas3 = faltas3;
     }

     @Override
     public boolean equals(Object o) {
          if (this == o) return true;
          if (!(o instanceof TurmasMatricula that)) return false;
          return ano == that.ano && semestre == that.semestre && Double.compare(that.nota1, nota1) == 0 && Double.compare(that.nota2, nota2) == 0 && Double.compare(that.nota3, nota3) == 0 && Objects.equals(diciplina, that.diciplina) && aluno.equals(that.aluno) && Objects.equals(professores, that.professores) && faltas1.equals(that.faltas1) && faltas2.equals(that.faltas2) && faltas3.equals(that.faltas3);
     }

     @Override
     public int hashCode() {
          return Objects.hash(ano, semestre, diciplina, aluno, professores, nota1, nota2, nota3, faltas1, faltas2, faltas3);
     }

     @Override
     public String toString() {
          return "TurmasMatricula{" +
                  "ano=" + ano +
                  ", semestre=" + semestre +
                  ", diciplina=" + diciplina +
                  ", aluno=" + aluno +
                  ", professores=" + professores +
                  ", nota1=" + nota1 +
                  ", nota2=" + nota2 +
                  ", nota3=" + nota3 +
                  ", faltas1=" + faltas1 +
                  ", faltas2=" + faltas2 +
                  ", faltas3=" + faltas3 +
                  '}';
     }
}
