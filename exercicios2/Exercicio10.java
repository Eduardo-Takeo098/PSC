package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio10 {
    public static void main(String[] args) {
        double a, b;

        a = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));
        b = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));

        if (a<b) {
            JOptionPane.showMessageDialog(
                null, "O Maior número é: " + b);
        } else {
            JOptionPane.showMessageDialog(
                null, "O Maior número é: " + a);
        }
    }
}
