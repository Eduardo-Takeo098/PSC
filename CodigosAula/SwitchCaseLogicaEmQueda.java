import javax.swing.JOptionPane;

public class SwitchCaseLogicaEmQueda {
    public static void main(String[] args) {
        int nota = Integer.parseInt(JOptionPane.showInputDialog("Digite a nota"));
        
        switch (nota) {
            case 10:
                JOptionPane.showMessageDialog(null, "Parabéns");
                break;

            case 9:
                JOptionPane.showMessageDialog(null, "Conceito A");
                break;

            case 8:
                JOptionPane.showMessageDialog(null, "Conceito B");
                break;

            case 7:
                JOptionPane.showMessageDialog(null, "Conceito C");
                break;
                
            default:
                JOptionPane.showMessageDialog(null, "Reprovado");
                break;

        }
    }
}