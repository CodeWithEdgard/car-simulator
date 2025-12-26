package br.com;

public class Application {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // xdg-open target/site/jacoco/index.html


        // // Quando diminuir a velocidade do carro ele deve decrementar 1 km de sua velocidade
        // (pode
        // // chegar no minimo a 0km);
        // public void diminuirVelocidde() {
        // if (velocidade == 0) {

        // ligado = true;
        // System.out.println("sua velocidade chegou a 0km o carro morreu");
        // }

        // velocidade -= 1;
        // }

        // // o carro deve possuir 6 marchas, não deve ser permitido pular uma marcha no carro;
        // public void trocarMarcha() {
        // int numeroMarchas = 6;

        // if (numeroMarchas == 0) {

        // System.out.println("ponto morto nao pode acelerar");
        // return;

        // } else if (numeroMarchas == 1) {

        // if (velocidade >= 0 || velocidade <= 20) {

        // acelerar();

        // } else {

        // System.out.println("LANÇAR UM ERRO DE LIMITE DE VELOCIDADE");
        // return;
        // }

        // }

        // /*
        // * se estiver na 2ª marcha sua velocidade pode estar entre 21km e 40km se estiver na 3ª
        // * marcha sua velocidade pode estar entre 41km e 60km se estiver na 4ª marcha sua
        // velocidade
        // * pode estar entre 61km e 80km se estiver na 5ª marcha sua velocidade pode estar entre
        // 81km
        // * e 100km se estiver na 6ª marcha sua velocidade pode estar entre 101km e 120km
        // */

        // }


        // // O carro podera ser desligado se estiver em ponto morto (marcha 0) e sua velocidade em
        // 0 km
        // public void desligarCarro() {

        // if (velocidade > 0) {
        // System.out.println("O CARRO SO PODE SER DESLIGADO COM VELOCIDADE 0");
        // return;
        // }

        // if (velocidade == 0) {

        // ligado = true;
        // System.out.println("Carro desligado");
        // }

        // }

        // // // O carro só pode virar para esquerda/direita se sua velocidade for de no mínimi 1km
        // e no
        // // máximo 40km;
        // public void virarEsquerdaOuDireita() {

        // if (velocidade == 0) {
        // System.out.println("PARA PODER FAZER A CURVA O CARRO PRECISA ESTAR PELO MENOS COM 1KM");
        // return;
        // } else if (velocidade > 40) {
        // System.out.println("PARA PODER FAZER A CURVA O CARRO PRECISA ESTAR VELOCIDADE < 40KM");
        // return;
        // } else if (velocidade >= 1 || velocidade <= 40) {

        // System.out.println(" Fazendo a curva");
        // }


        // }
    }
}
