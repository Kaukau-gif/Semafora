/**
 * Módulo de LÓGICA (Model).
 * Guarda os 3 estados possíveis do semáforo e sabe avançar entre eles.
 * Não conhece nada sobre Swing / interface gráfica (encapsulamento).
 */
public class LogicaSemaforo {

    private String[] estados = {"VERMELHO", "AMARELO", "VERDE"};
    private int indiceAtual = 0;

    public String estadoAtual() {
        return estados[indiceAtual];
    }

    public void avancar() {
        // Avança para o próximo índice do array.
        // O operador % faz voltar ao início (0) depois do último estado.
        indiceAtual = (indiceAtual + 1) % estados.length;
    }

    // Teste rápido da lógica pelo console, sem depender da interface gráfica.
    public static void main(String[] args) {
        LogicaSemaforo semaforo = new LogicaSemaforo();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar();
        System.out.println(semaforo.estadoAtual());
        semaforo.avancar();
        System.out.println(semaforo.estadoAtual());
    }
}
