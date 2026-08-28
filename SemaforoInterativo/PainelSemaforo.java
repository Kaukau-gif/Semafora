import javax.swing.*;
import java.awt.*;

/**
 * Módulo de DESENHO (View - parte gráfica).
 * JPanel customizado que sobrescreve paintComponent (herança/polimorfismo)
 * para desenhar os 3 círculos do semáforo.
 * Apenas o círculo do estado atual aparece aceso; os outros ficam cinza.
 */
public class PainelSemaforo extends JPanel {

    private String estadoAtual = "VERMELHO";

    public PainelSemaforo() {
        setPreferredSize(new Dimension(200, 420));
        setBackground(new Color(30, 30, 30));
    }

    // Chamado pela GUI sempre que o estado do semáforo mudar.
    public void atualizarEstado(String novoEstado) {
        this.estadoAtual = novoEstado;
        repaint(); // força o redesenho da tela com o novo estado
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int diametro = 100;
        int x = (getWidth() - diametro) / 2;

        // Cada círculo só fica colorido se for o estado atual; senão, fica cinza (apagado).
        g2.setColor(estadoAtual.equals("VERMELHO") ? Color.RED : Color.DARK_GRAY);
        g2.fillOval(x, 40, diametro, diametro);

        g2.setColor(estadoAtual.equals("AMARELO") ? Color.YELLOW : Color.DARK_GRAY);
        g2.fillOval(x, 160, diametro, diametro);

        g2.setColor(estadoAtual.equals("VERDE") ? Color.GREEN : Color.DARK_GRAY);
        g2.fillOval(x, 280, diametro, diametro);
    }
}
