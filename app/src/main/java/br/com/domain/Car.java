package br.com.domain;

import br.com.domain.enums.Marcha;

public class Car {

    private boolean ligado;

    private int velocidade;

    private Marcha marcha;


    public Car() {
        // Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade
        // em 0
        this.ligado = false;
        this.velocidade = 0;
        this.marcha = marcha.PONTO_MORTO;
    }

    public boolean getLigado() {
        return this.ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public int getVelocidade() {
        return this.velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Marcha getMarcha() {
        return this.marcha;
    }

    public void setMarcha(Marcha marcha) {
        this.marcha = marcha;
    }
}
