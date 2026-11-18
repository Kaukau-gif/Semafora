# 🚦 Semáforo Interativo em Java

Aplicação com interface gráfica em **Java Swing** que simula um semáforo. A cada clique em **Avançar**, a luz muda de vermelho para amarelo, de amarelo para verde e de verde de volta para vermelho, como está definido na lógica do projeto.

O objetivo foi praticar **Programação Orientada a Objetos**, separando a regra de negócio da interface.

## Como o código está organizado

| Classe | Papel |
|---|---|
| `LogicaSemaforo` | **Modelo.** Guarda os 3 estados e sabe avançar para o próximo. Não depende do Swing. |
| `PainelSemaforo` | Desenha o semáforo e acende a luz do estado atual. |
| `SemaforoGUI` | Monta a janela e o botão **Avançar**, ligando o clique à lógica. |
| `Main` | Ponto de entrada da aplicação. |

Os estados ficam em um array, e o operador `%` faz a sequência voltar ao início depois do último estado:

```java
indiceAtual = (indiceAtual + 1) % estados.length;
```

## Como executar

Requer o **JDK 8** ou mais recente.

```bash
cd SemaforoInterativo
javac *.java
java Main
```

Para testar só a lógica pelo console, sem interface:

```bash
java LogicaSemaforo
```

## O que aprendi

- Encapsulamento e separação de responsabilidades (lógica × interface)
- Criação de interfaces gráficas com Swing
- Tratamento de eventos de clique

---
Feito por [Kauany Paula da Silva](https://github.com/Kaukau-gif) durante o curso de Análise e Desenvolvimento de Sistemas.
