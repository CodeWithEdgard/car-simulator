<div align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white" alt="Maven">
  <img src="https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white" alt="JUnit 5">
  <img src="https://img.shields.io/badge/JaCoCo-3775A9?style=for-the-badge&logo=jacoco&logoColor=white" alt="JaCoCo">
  <img src="https://img.shields.io/badge/SLF4J-Logging-blue?style=for-the-badge" alt="SLF4J">
  <img src="https://img.shields.io/badge/GitHub_Actions-2088FF?style=for-the-badge&logo=github-actions&logoColor=white" alt="GitHub Actions">
</div>

# Car Simulator 🚗💨

**Um simulador simples e realista de controle de carro em Java.**

Este projeto foi criado para praticar conceitos importantes de programação orientada a objetos e desenvolvimento backend em Java. Ele simula o comportamento de um carro manual com regras parecidas com as de um carro de verdade (marchas, velocidade limitada por marcha, etc.).

Perfeito para quem está aprendendo Java e quer ver na prática como aplicar boas práticas de código limpo, testes e organização de projeto.

[Índice](#índice) • [O que o simulador faz](#o-que-o-simulador-faz) • [Regras principais](#regras-principais) • [Tecnologias usadas](#tecnologias-usadas) • [Estrutura do código](#estrutura-do-código) • [Como rodar](#como-rodar) • [Testes](#testes) • [Contato](#contato)

## Índice

- [O que o simulador faz](#o-que-o-simulador-faz)
- [Regras principais](#regras-principais)
- [Tecnologias usadas](#tecnologias-usadas)
- [Estrutura do código](#estrutura-do-código)
- [Como rodar o projeto](#como-rodar-o-projeto)
- [Testes e cobertura](#testes-e-cobertura)
- [Contato e feedback](#contato-e-feedback)

## O que o simulador faz

Você pode controlar um carro virtual através de comandos simples:

- Ligar e desligar o carro
- Acelerar e frear (de 1 em 1 km/h)
- Trocar de marcha (1ª até 6ª + ponto morto)
- Virar à esquerda ou à direita

O simulador **não deixa fazer coisas impossíveis**, como:

- Trocar de marcha pulando etapas
- Acelerar além do limite da marcha atual
- Virar em alta velocidade
- Desligar o carro em movimento

Tudo isso é controlado por uma **máquina de estados** (state machine) e validações inteligentes — conceitos muito usados em sistemas reais.

## Regras principais (bem simples)

- O carro começa **desligado**, em **ponto morto** (marcha 0) e velocidade **0 km/h**.
- Quando está desligado, nenhum comando funciona.
- Acelerar ou frear muda a velocidade em **1 km/h** por vez.
- Velocidade máxima: **120 km/h**.
- Existem 6 marchas + ponto morto. Cada marcha tem um limite de velocidade:
  - Ponto morto → só 0 km/h
  - 1ª marcha → até 20 km/h
  - 2ª marcha → até 40 km/h
  - 3ª marcha → até 60 km/h
  - 4ª marcha → até 80 km/h
  - 5ª marcha → até 100 km/h
  - 6ª marcha → até 120 km/h
- Não pode pular marchas (ex: de 1ª direto pra 3ª).
- Só pode virar entre **1 e 40 km/h**.
- Só pode desligar o carro se estiver em ponto morto e parado.

## Tecnologias usadas

- **Java 17** → linguagem principal
- **Maven** → para organizar e construir o projeto
- **SLF4J** → para mostrar mensagens organizadas no console (logs)
- **JUnit 5** → testes automáticos
- **JaCoCo** → mede quanto do código está sendo testado
- **GitHub Actions** → roda os testes automaticamente a cada mudança

Boas práticas aplicadas:

- Código organizado (SOLID)
- Injeção de dependências manual
- Exceções personalizadas
- Constantes centralizadas
- Programação para interfaces

## Estrutura do código

O projeto segue uma arquitetura limpa (Clean Architecture) para deixar tudo bem separado:

```
src/main/java/br/com/zpx/car/
├── domain/          → A classe Car (guarda apenas o estado do carro)
├── config/          → Constantes (limites de velocidade, etc.)
├── exception/       → Mensagens de erro personalizadas
├── service/         → Lógica principal + logs
└── presentation/    → DemoConsole (exemplo de uso no terminal)
```

## Como rodar o projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/seu-usuario/car-simulator.git
   cd car-simulator
   ```

2. Rode os testes (recomendado):

   ```bash
   mvn clean test
   ```

3. Execute a demonstração no console:
   ```bash
   mvn exec:java -Dexec.mainClass="br.com.zpx.car.presentation.DemoConsole"
   ```

Você verá mensagens como:

```
[INFO] Carro ligado com sucesso!
[INFO] Acelerando... Velocidade atual: 15 km/h
[INFO] Trocando para 2ª marcha
[INFO] Vruuum! Virando à esquerda
```

Siga as instruções na tela para controlar o carro!

## Testes e cobertura

Todos os comportamentos importantes estão cobertos por testes unitários.  
A cobertura é alta (próxima de 100% nas partes críticas).

Para gerar o relatório localmente:

```bash
mvn clean test jacoco:report
```

Depois abra o arquivo: `target/site/jacoco/index.html`
