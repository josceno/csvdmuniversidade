package modelo_relacional;

public class HistoricosEscolares {
    private int ano;
    private int semestre;
    private Aluno aluno;
    private Diciplina diciplina;
    private double media;
    private  int faltas;
    private String situacao;

    public HistoricosEscolares(int ano, int semestre, Aluno aluno, Diciplina diciplina, double media,int faltas, String situacao) {
        this.ano = ano;
        this.semestre = semestre;
        this.aluno = aluno;
        this.diciplina = diciplina;
        this.media = media;
        this.faltas =  faltas;
        this.situacao = situacao;
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

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        this.faltas = faltas;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Diciplina getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(Diciplina diciplina) {
        this.diciplina = diciplina;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "HistoricosEscolares{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", aluno=" + aluno +
                ", diciplina=" + diciplina +
                ", media=" + media +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
