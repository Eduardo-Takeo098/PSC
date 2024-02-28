package Exercicio;

import javax.swing.JOptionPane;

public class Exercicio5 {
    public static void main(String[] args) {
        double num, negativo;
        num = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));

        if (num < 0) {
            negativo = num * num;
            JOptionPane.showMessageDialog(null, negativo);
        } else {
            JOptionPane.showMessageDialog(null, Math.sqrt(num));
        }
    }
}
