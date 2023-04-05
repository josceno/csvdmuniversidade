package modelo_relacional;

import java.util.Objects;

public class Curriculo {

      private Curso codCurso;
      private Diciplina codDiciplina;
      private int periodo;

    public Curriculo(Curso codCurso, Diciplina codDiciplina, int periodo) {
        this.codCurso = codCurso;
        this.codDiciplina = codDiciplina;
        this.periodo = periodo;
    }

    public Curso getCodCurso() {
        return codCurso;
    }

    public Diciplina getCodDiciplina() {
        return codDiciplina;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setCodCurso(Curso codCurso) {
        this.codCurso = codCurso;
    }

    public void setCodDiciplina(Diciplina codDiciplina) {
        this.codDiciplina = codDiciplina;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Curriculo curriculo)) return false;
        return periodo == curriculo.periodo && codCurso.equals(curriculo.codCurso) && codDiciplina.equals(curriculo.codDiciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codCurso, codDiciplina, periodo);
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                ", codCurso=" + codCurso +
                ", codDiciplina=" + codDiciplina +
                ", periodo=" + periodo +
                '}';
    }
}
