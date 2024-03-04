package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio5 {
    public static void main(String[] args) {
        double num, negativo;
        num = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));

        if (num < 0) {
            negativo = num * num;
            JOptionPane.showMessageDialog(null, "O quadrado desse número é: " + negativo);
        } else {
            JOptionPane.showMessageDialog(null, "A raiz desse número é: " + Math.sqrt(num));
        }
    }
}
