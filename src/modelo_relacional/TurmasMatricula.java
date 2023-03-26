package modelo_relacional;

public class TurmasMatricula {
     private int ano;
     private int semestre;
     private Diciplina diciplina;
     private String nome;
     private  Aluno aluno;
     private  double nota1;
     private  double nota2;
     private  double nota3;
     private  double nota4;
     private  Integer faltas1;
     private Integer faltas2;
     private  Integer faltas3;

     public TurmasMatricula(int ano, int semestre, Diciplina diciplina, String nome,Aluno aluno, double nota1, double nota2, double nota3, double nota4,Integer faltas1, Integer faltas2, Integer faltas3) {
          this.ano = ano;
          this.semestre = semestre;
          this.nome = nome;
          this.diciplina = diciplina;
          this.aluno = aluno;
          this.nota1 = nota1;
          this.nota2 = nota2;
          this.nota3 = nota3;
          this.nota4 = nota4;
          this.faltas1 = faltas1;
          this.faltas2 = faltas2;
          this.faltas3 = faltas3;
     }

     public int getAno() {
          return ano;
     }

     public void setAno(int ano) {
          this.ano = ano;
     }

     public int getSemestre() {
          return semestre;
     }

     public void setSemestre(int semestre) {
          this.semestre = semestre;
     }

     public Diciplina getDiciplina() {
          return diciplina;
     }

     public void setDiciplina(Diciplina diciplina) {
          this.diciplina = diciplina;
     }

     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public Aluno getAluno() {
          return aluno;
     }

     public void setAluno(Aluno aluno) {
          this.aluno = aluno;
     }

     public double getNota1() {
          return nota1;
     }

     public void setNota1(double nota1) {
          this.nota1 = nota1;
     }

     public double getNota2() {
          return nota2;
     }

     public void setNota2(double nota2) {
          this.nota2 = nota2;
     }

     public double getNota3() {
          return nota3;
     }

     public void setNota3(double nota3) {
          this.nota3 = nota3;
     }

     public double getNota4() {
          return nota4;
     }

     public void setNota4(double nota4) {
          this.nota4 = nota4;
     }

     public Integer getFaltas1() {
          return faltas1;
     }

     public void setFaltas1(Integer faltas1) {
          this.faltas1 = faltas1;
     }

     public Integer getFaltas2() {
          return faltas2;
     }

     public void setFaltas2(Integer faltas2) {
          this.faltas2 = faltas2;
     }

     public Integer getFaltas3() {
          return faltas3;
     }

     public void setFaltas3(Integer faltas3) {
          this.faltas3 = faltas3;
     }



     @Override
     public String toString() {
          return "TurmasMatricula{" +
                  "ano=" + ano +
                  ", semestre=" + semestre +
                  ", diciplina=" + diciplina +
                  ", aluno=" + aluno +
                  ", nota1=" + nota1 +
                  ", nota2=" + nota2 +
                  ", nota3=" + nota3 +
                  ", nota4=" + nota4 +
                  ", faltas1=" + faltas1 +
                  ", faltas2=" + faltas2 +
                  ", faltas3=" + faltas3 +
                  '}';
     }
}
