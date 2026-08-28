import javax.swing.SwingUtilities;

/**
 * Módulo PRINCIPAL.
 * Único responsável por iniciar a aplicação (ponto de entrada).
 */
public class Main {
    public static void main(String[] args) {
        // Garante que a interface gráfica rode na thread correta do Swing.
        SwingUtilities.invokeLater(() -> {
            SemaforoGUI janela = new SemaforoGUI();
            janela.setVisible(true);
        });
    }
}
