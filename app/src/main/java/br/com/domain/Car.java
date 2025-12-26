package br.com.domain;

public class Car {

    private boolean ligado;

    private int velocidade;


    public Car() {
        // Quando o carro for criado ele deve começar desligado, em ponto morto e com sua velocidade
        // em 0
        this.ligado = false;
        this.velocidade = 0;
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

    @Override
    public String toString() {

        return "Car{" + "ligado=" + ligado + ", velocidade=" + velocidade + '}';

    }
}
