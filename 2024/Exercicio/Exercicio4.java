package Exercicio;

import javax.swing.JOptionPane;

public class Exercicio4 {
   public static void main(String[] args) {
    int num1, num2, soma;

    num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
    num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro número"));

    soma = num1 + num2;

    if (soma <= 20) {
        JOptionPane.showMessageDialog(null, soma - 5);
    }
   } 
}
