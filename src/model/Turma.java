package model;

import java.util.Objects;

public class Turma {
    private int ano;
    private int semestre;
    private String turma;
    private Diciplina deciplina;
    private  int totalVagas;
    private  int vagasOcupadas;
    private Professores professor;

    public Turma(int ano, int semestre, String turma, Diciplina deciplina, int totalVagas, int vagasOcupadas, Professores professor) {
        this.ano = ano;
        this.semestre = semestre;
        this.turma = turma;
        this.deciplina = deciplina;
        this.totalVagas = totalVagas;
        this.vagasOcupadas = vagasOcupadas;
        this.professor = professor;
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

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Diciplina getDeciplina() {
        return deciplina;
    }

    public void setDeciplina(Diciplina deciplina) {
        this.deciplina = deciplina;
    }

    public int getTotalVagas() {
        return totalVagas;
    }

    public void setTotalVagas(int totalVagas) {
        this.totalVagas = totalVagas;
    }

    public int getVagasOcupadas() {
        return vagasOcupadas;
    }

    public void setVagasOcupadas(int vagasOcupadas) {
        this.vagasOcupadas = vagasOcupadas;
    }

    public Professores getProfessor() {
        return professor;
    }

    public void setProfessor(Professores professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Turma turma1)) return false;
        return ano == turma1.ano && semestre == turma1.semestre && totalVagas == turma1.totalVagas && vagasOcupadas == turma1.vagasOcupadas && Objects.equals(turma, turma1.turma) && Objects.equals(deciplina, turma1.deciplina) && Objects.equals(professor, turma1.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ano, semestre, turma, deciplina, totalVagas, vagasOcupadas, professor);
    }

    @Override
    public String toString() {
        return "Turma{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", turma='" + turma + '\'' +
                ", deciplina=" + deciplina +
                ", totalVagas=" + totalVagas +
                ", vagasOcupadas=" + vagasOcupadas +
                ", professor=" + professor +
                '}';
    }
}
