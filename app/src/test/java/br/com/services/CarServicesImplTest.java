package br.com.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.domain.Car;
import br.com.domain.enums.Marcha;
import br.com.exception.CarDesligadoException;
import br.com.exception.PontoMortoException;
import br.com.exception.VelocidadeMaximaException;

public class CarServicesImplTest {

    private Car carro;
    private CarService service;

    @BeforeEach
    void setUp() {

        carro = new Car();
        service = new CarServicesImpl(carro);

    }

    @Test
    public void deveAcelerarComSucesso() {

        service.ligarCarro();

        service.trocarMarcha(Marcha.PRIMEIRA);

        service.acelerar();

        assertEquals(1, carro.getVelocidade());

    }

    @Test
    public void acelerarComCarroDesligadoLancaException() {

        CarDesligadoException e =
                assertThrows(CarDesligadoException.class, () -> service.acelerar());

        assertTrue(e.getMessage().contains("desligado"));
    }

    @Test
    public void acelerarVelocidadeMaximaException() {

        service.ligarCarro();
        carro.setVelocidade(120);

        VelocidadeMaximaException e =
                assertThrows(VelocidadeMaximaException.class, () -> service.acelerar());

        assertTrue(e.getMessage().contains("velocidade Maxima"));
    }

    @Test
    public void ligarOcarroComSucesso() {

        service.ligarCarro();

        assertTrue(carro.getLigado());
    }

    @Test
    public void ligarOcarroPontoMortoException() {

        carro.setVelocidade(100);

        PontoMortoException e = assertThrows(PontoMortoException.class, () -> service.ligarCarro());

        assertTrue(e.getMessage().contains("no ponto morto para ligar"));

    }

    @Test
    public void desligarOcarroComSucesso() {

        service.ligarCarro();

        service.desligarCarro();

        assertFalse(carro.getLigado());
    }

    @Test
    public void desligarOcarroCarDesligadoException() {

        service.ligarCarro();

        service.trocarMarcha(Marcha.PRIMEIRA);

        service.acelerar();

        CarDesligadoException e =
                assertThrows(CarDesligadoException.class, () -> service.desligarCarro());

        assertFalse(e.getMessage().equals("Não é possivel desligar o carro"));
    }

    @Test
    public void diminuirVelocidadeComSucesso() {

        service.ligarCarro();

        carro.setVelocidade(110);

        service.diminuirVelocidade();

        assertEquals(109, carro.getVelocidade());
    }

    @Test
    public void diminuirVelocidadeComCarroDesligadoLancaException() {

        CarDesligadoException e =
                assertThrows(CarDesligadoException.class, () -> service.diminuirVelocidade());

        assertTrue(e.getMessage().contains("Carro esta desligado"));
    }

    @Test
    public void diminuirVelocidadeIgualAZeroLancaException() {

        service.ligarCarro();

        PontoMortoException e =
                assertThrows(PontoMortoException.class, () -> service.diminuirVelocidade());

        assertTrue(e.getMessage().contains("Velocidade minima"));
    }

    @Test
    public void deveTrocarMarchaComSucesso() {

        service.ligarCarro();

        service.trocarMarcha(Marcha.PRIMEIRA);

        assertEquals(Marcha.PRIMEIRA, carro.getMarcha());
        
    }
}
