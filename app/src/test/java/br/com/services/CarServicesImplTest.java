package br.com.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.domain.Car;
import br.com.exception.CarDesligadoException;
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

        carro.setLigado(true);
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

        carro.setLigado(true);
        carro.setVelocidade(120);

        VelocidadeMaximaException e =
                assertThrows(VelocidadeMaximaException.class, () -> service.acelerar());

        assertTrue(e.getMessage().contains("velocidade Maxima"));
    }

}
