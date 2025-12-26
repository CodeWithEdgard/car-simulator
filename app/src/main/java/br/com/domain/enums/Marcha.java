package br.com.domain.enums;

public enum Marcha {

    PONTO_MORTO(0), PRIMEIRA(1), SEGUNDA(2), TERCEIRA(3), QUARTA(4), QUINTA(5), SEXTA(6);

    private final int valor;

    Marcha(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }


}
