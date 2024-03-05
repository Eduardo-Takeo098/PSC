import javax.swing.JOptionPane;

public class ExercicioDoProfessor6 {
    public static void main(String[] args) {
        int a, b, c;
        String saida;
        a = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número:"));
        b = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número:"));
        c = Integer.parseInt(JOptionPane.showInputDialog("Digite o terceiro número:"));

        if (a < b && b < c) {
            saida = a + ", " + b + ", " + c;
        } else if (a < c && c < b) {
            saida = a + ", " + c + ", " + b;
        } else if (b < a && a < c) {
            saida = b + ", " + a + ", " + c;
        } else if (b < c && c < a) {
            saida = b + ", " + c + ", " + b;
        } else if (c < a && a < b) {
            saida = c + ", " + a + ", " + b;
        } else if (c < b && c < a) {
            saida = c + ", " + b + ", " + a;
        } else {
            saida = "Números inválidos";
        }

        JOptionPane.showMessageDialog(null, saida);
    }
}
