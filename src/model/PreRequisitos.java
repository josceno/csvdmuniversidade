package model;

public class PreRequisitos {
    private Diciplina diciplina;

    public PreRequisitos(Diciplina diciplina) {
        this.diciplina = diciplina;
    }

    public Diciplina getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(Diciplina diciplina) {
        this.diciplina = diciplina;
    }

    @Override
    public String toString() {
        return "PreRequisitos{" +
                "diciplina=" + diciplina +
                '}';
    }
}
