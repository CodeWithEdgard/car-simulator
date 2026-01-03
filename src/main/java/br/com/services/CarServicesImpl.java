package br.com.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import br.com.domain.Car;
import br.com.domain.enums.Marcha;
import br.com.exception.CarDesligadoException;
import br.com.exception.PontoMortoException;
import br.com.exception.VelocidadeMaximaException;

public class CarServicesImpl implements CarService {

    private static final Logger Log = LoggerFactory.getLogger(CarServicesImpl.class);

    private Car carro;

    public CarServicesImpl(Car carro) {
        this.carro = carro;
    }

    @Override
    public void ligarCarro() {

        if (carro.getVelocidade() != 0) {
            throw new PontoMortoException("O carro precisa estar no ponto morto para ligar");
        }

        carro.setLigado(true);
    }

    // O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em 0 km
    @Override
    public void desligarCarro() {

        if (carro.getVelocidade() != 0) {
            throw new CarDesligadoException(
                    "Não é possivel desligar o carro caso esteja com velocidade > 0");

        }

        carro.setLigado(false);

    }

    // Quando o carro for acelerado ele deve incrementar 1km em sua velocidade (pode chegar no
    // máximo a 120km);
    @Override
    public void acelerar() {

        if (!carro.getLigado()) {

            throw new CarDesligadoException(
                    "Carro esta desligado não e possivel fazer nenhuma ação");
        }

        if (carro.getVelocidade() >= 120) {
            throw new VelocidadeMaximaException(
                    "Não é possivel acelerar, alcançado  velocidade Maxima 120km");
        }

        if (carro.getMarcha() == Marcha.PONTO_MORTO) {
            throw new PontoMortoException("Para acelerar precisa sair do ponto morto");
        }

        if (carro.getMarcha() == Marcha.PRIMEIRA) {

            if (carro.getVelocidade() < 0 || carro.getVelocidade() > 19) {
                throw new VelocidadeMaximaException(
                        "velocidade maxima alcanda na primeira, troque de marcha");
            }

            carro.setVelocidade(carro.getVelocidade() + 1);
            Log.info("Voce aumentou a velocidade, estamos em: " + carro.getVelocidade());
        }

        // TO DO (fazer para as outras marchas, e analisar algo para diminuir os if)
    }

    // Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade (pode
    // chegar no minimo a 0km);
    @Override
    public void diminuirVelocidade() {

        if (!carro.getLigado()) {

            throw new CarDesligadoException(
                    "Carro esta desligado não e possivel fazer nenhuma ação");
        }

        if (carro.getVelocidade() == 0) {

            throw new PontoMortoException("Velocidade minima");

        }

        carro.setVelocidade(carro.getVelocidade() - 1);
        Log.info("Voce diminuiu a velocidade, estamos em: " + carro.getVelocidade());

    }


    // o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
    @Override
    public void trocarMarcha(Marcha trocaMarcha) {

        Marcha marchaAtual = trocaMarcha;

        if (marchaAtual.equals(null)) {

            throw new NullPointerException("Por favor escolha uma marcha");
        }

        carro.setMarcha(marchaAtual);

    }



    @Override
    public void virarEsquerda() {}

    @Override
    public void virarDireita() {}



}
