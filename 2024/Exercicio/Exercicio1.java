package Exercicio;
import javax.swing.JOptionPane;

public class Exercicio1 {
    public static void main(String[] args) {
        double salario;

        salario = Double.parseDouble(JOptionPane.showInputDialog("Qual seu salário? "));

        if (salario < 1320) {
            JOptionPane.showMessageDialog(
                null, "Seu salário é menor que o salário minimo");
            }   else if (salario == 1320) {
                    JOptionPane.showMessageDialog(
                        null, "Seu salário é igual ao salário minimo");
                }   else if (salario > 1320) {
                        JOptionPane.showMessageDialog(
                            null, "Seu salário é maior ao salário minimo");
                    }
        }
}
