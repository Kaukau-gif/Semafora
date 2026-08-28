import javax.swing.*;
import java.awt.*;

/**
 * Módulo de INTERFACE (View - janela principal).
 * Monta o JFrame com o painel dos círculos, o rótulo de estado e o botão "Avançar".
 * O ActionListener do botão só chama métodos da lógica (LogicaSemaforo) —
 * nenhuma regra de negócio fica aqui dentro.
 */
public class SemaforoGUI extends JFrame {

    private final LogicaSemaforo logica;   // objeto da lógica (composição)
    private final PainelSemaforo painel;   // painel customizado dos círculos
    private final JLabel labelEstado;

    public SemaforoGUI() {
        this.logica = new LogicaSemaforo();
        this.painel = new PainelSemaforo();
        this.labelEstado = new JLabel("Estado: " + logica.estadoAtual(), SwingConstants.CENTER);

        configurarJanela();
        criarComponentes();
    }

    private void configurarJanela() {
        setTitle("Semáforo Interativo - Java OOP");
        setSize(260, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));
    }

    private void criarComponentes() {
        labelEstado.setFont(new Font("SansSerif", Font.BOLD, 16));
        labelEstado.setForeground(Color.WHITE);

        JButton botaoAvancar = new JButton("Avançar");
        botaoAvancar.addActionListener(e -> {
            // O listener só chama métodos da lógica e depois atualiza a tela.
            logica.avancar();
            labelEstado.setText("Estado: " + logica.estadoAtual());
            painel.atualizarEstado(logica.estadoAtual());
        });

        JPanel painelInferior = new JPanel(new BorderLayout());
        painelInferior.setBackground(new Color(30, 30, 30));
        painelInferior.add(labelEstado, BorderLayout.NORTH);
        painelInferior.add(botaoAvancar, BorderLayout.SOUTH);

        getContentPane().setBackground(new Color(30, 30, 30));
        add(painel, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);
    }
}
