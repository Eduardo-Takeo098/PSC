package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio7 {
    public static void main(String[] args) {
        double num = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));

        if (num >= 20 || num >= 90) {
            JOptionPane.showMessageDialog(null, "Seu número " + num + " está entre 20 e 90");
        } else {
            JOptionPane.showMessageDialog(null, "Seu número " + num + " não está entre 20 e 90");
        }
    }
}
