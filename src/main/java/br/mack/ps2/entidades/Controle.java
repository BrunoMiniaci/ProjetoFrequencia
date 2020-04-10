package br.mack.ps2.entidades;

public class Controle {
    private int tia;
    private String entrada;
    private String saida;

    public Controle() {}

    public Controle(int tia, String entrada, String saida) {
        this.tia = tia;
        this.entrada = entrada;
        this.saida = saida;
    }

    public int getTia() {
        return tia;
    }

    public void setTia(int tia) {
        this.tia = tia;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return entrada +
                " [TIA #:" + tia +
                ",Horario de Saida: " + saida + "]";
    }
}

