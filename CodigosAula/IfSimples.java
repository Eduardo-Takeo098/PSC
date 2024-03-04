import javax.swing.JOptionPane;

public class IfSimples {
    public static void main(String[] args) {
        double nota;
        nota = Double.parseDouble(JOptionPane.showInputDialog("Qual sua nota: "));

        if (nota >= 70) {
            JOptionPane.showMessageDialog(null, "Aprovado");
        }
    }
}
