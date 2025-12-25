package br.com.domain;

public class Car {

    private boolean ligado;

    private int velocidade;


    public Car() {}

    public Car(boolean ligado, int velocidade) {
        this.ligado = ligado;
        this.velocidade = velocidade;
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
