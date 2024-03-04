package exercicios1;

import javax.swing.JOptionPane;

public class Exercicio2 {
    public static void main(String[] args) {
        double num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número:"));
        double num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número:"));
        double num3 = Double.parseDouble(JOptionPane.showInputDialog("Digite o terceiro número:"));
        double num4 = Double.parseDouble(JOptionPane.showInputDialog("Digite o quarto número:"));
        
        double somaDosQuadrados = (num1 * num1) + (num2 * num2) + (num3 * num3) + (num4 * num4);
        
        JOptionPane.showMessageDialog(null, "A soma dos quadrados é: " + somaDosQuadrados);
    }
}
