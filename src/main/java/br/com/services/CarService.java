package br.com.services;

import br.com.domain.enums.Marcha;

public interface CarService {

    void ligarCarro();

    void acelerar();

    void diminuirVelocidade();

    void trocarMarcha(Marcha trocarMarcha);

    void desligarCarro();

    void virarEsquerda();

    void virarDireita();


}
