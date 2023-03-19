package model;

import java.util.Objects;

public class Curriculo {
      private int codigo;
      private Curso codCurso;
      private Diciplina codDiciplina;
      private int periodo;

    public Curriculo(int codigo, Curso codCurso, Diciplina codDiciplina, int periodo) {
        this.codigo = codigo;
        this.codCurso = codCurso;
        this.codDiciplina = codDiciplina;
        this.periodo = periodo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
        return codigo == curriculo.codigo && periodo == curriculo.periodo && codCurso.equals(curriculo.codCurso) && codDiciplina.equals(curriculo.codDiciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, codCurso, codDiciplina, periodo);
    }

    @Override
    public String toString() {
        return "Curriculo{" +
                "codigo=" + codigo +
                ", codCurso=" + codCurso +
                ", codDiciplina=" + codDiciplina +
                ", periodo=" + periodo +
                '}';
    }
}
