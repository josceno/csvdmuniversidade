package modelo_dimensional;

import modelo_relacional.Aluno;
import modelo_relacional.Diciplina;

public class TurmaDm {
    private int turma;
    private String nome;
    private  double nota1;
    private  double nota2;
    private  double nota3;
    private  double nota4;
    private double media;
    private  Integer faltas1;
    
    public TurmaDm( String nome, double nota1, double nota2, double nota3, double nota4, Integer faltas1) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.faltas1 = faltas1;
        this.media = nota1+nota2+nota3+nota4/4;
    }
    public TurmaDm(int turma, String nome, double nota1, double nota2, double nota3, double nota4, Integer faltas1) {
        this.turma = turma;
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.faltas1 = faltas1;
        this.media = nota1+nota2+nota3+nota4/4;
    }

    

    public int getTurma() {
        return turma;
    }
    public String getNome() {
        return nome;
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
    public double getMedia() {
        return media;
    }
    public Integer getFaltas1() {
        return faltas1;
    }
    @Override
    public String toString() {
        return "TurmaDm{" +
                "turma=" + turma +
                ", nome='" + nome + '\'' +
                ", nota1=" + nota1 +
                ", nota2=" + nota2 +
                ", nota3=" + nota3 +
                ", nota4=" + nota4 +
                ", media=" + media +
                ", faltas1=" + faltas1 +
                '}';
    }
}
