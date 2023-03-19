package model;

import java.util.Objects;

public class Conceito {
    private char connceito;
    private double faixaInicial;
    private double faixaFinal;

    public Conceito(char connceito, double faixaInicial, double faixaFinal) {
        this.connceito = connceito;
        this.faixaInicial = faixaInicial;
        this.faixaFinal = faixaFinal;
    }

    public char getConnceito() {
        return connceito;
    }

    public void setConnceito(char connceito) {
        this.connceito = connceito;
    }

    public double getFaixaInicial() {
        return faixaInicial;
    }

    public void setFaixaInicial(double faixaInicial) {
        this.faixaInicial = faixaInicial;
    }

    public double getFaixaFinal() {
        return faixaFinal;
    }

    public void setFaixaFinal(double faixaFinal) {
        this.faixaFinal = faixaFinal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Conceito conceito)) return false;
        return connceito == conceito.connceito && Double.compare(conceito.faixaInicial, faixaInicial) == 0 && Double.compare(conceito.faixaFinal, faixaFinal) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(connceito, faixaInicial, faixaFinal);
    }

    @Override
    public String toString() {
        return "Conceito{" +
                "connceito=" + connceito +
                ", faixaInicial=" + faixaInicial +
                ", faixaFinal=" + faixaFinal +
                '}';
    }
}
