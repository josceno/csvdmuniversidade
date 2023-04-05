package modelo_dimensional;

import modelo_relacional.Aluno;
import modelo_relacional.Professores;
import repositorio.Repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CursoDm {
    private int codigoCurso;
    private int qtdAlunos;
    private double mgp;
    //private String nome;
    Repositorio repositorio;


    public CursoDm(int codigoCurso, Repositorio repositorio) {
        this.codigoCurso = codigoCurso;
        this.qtdAlunos = qtdAluno();
        this.mgp = clcmedia();
        this.repositorio = repositorio;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public double getMgp() {
        return mgp;
    }

    public void setMgp(double mgp) {
        this.mgp = mgp;
    }
    public double clcmedia(){
        //List<Aluno> alunosmedia = new ArrayList<>();
        int i = 0;
        double nota = 0.0;
        for (Aluno aluno: repositorio.alunos()) {
            if(aluno.getCodigoCurso().getCodigoCurso() == codigoCurso){
                i++;
                nota = aluno.getMgp();
            }

        }
        return nota/i;
    }
    public int qtdAluno(){
        int quantidade = 0;
        for (Aluno aluno : repositorio.alunos()) {
            if(aluno.getCodigoCurso().getCodigoCurso()  == this.codigoCurso){
                ++quantidade;
            }
        }
        return quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CursoDm cursoDm)) return false;
        return codigoCurso == cursoDm.codigoCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCurso);
    }
}
