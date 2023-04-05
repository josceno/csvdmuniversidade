package modelo_dimensional;

import java.sql.Date;

public class TempoDm {
    private int ano;
    private int semestre;
    private Integer mes;

    private Integer dia;
    private Date dtcompleta;
    public TempoDm(){}

    public TempoDm(int ano, int semestre) {
        this.ano = ano;
        this.semestre = semestre;
    }
    public TempoDm(int ano, int semestre, Integer mes, Integer dia, Date dtcompleta) {
        this.ano = ano;
        this.semestre = semestre;
        this.mes = mes;
        this.dia = dia;
        this.dtcompleta = dtcompleta;
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

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Date getDtcompleta() {
        return dtcompleta;
    }

    public void setDtcompleta(Date dtcompleta) {
        this.dtcompleta = dtcompleta;
    }

    @Override
    public String toString() {
        return "TempoDm{" +
                "ano=" + ano +
                ", semestre=" + semestre +
                ", mes=" + mes +
                ", dia=" + dia +
                ", dtcompleta=" + dtcompleta +
                '}';
    }
}
