package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio2 {
    public static void main(String[] args) {
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual sua idade? "));

        if (idade < 18){
            JOptionPane.showMessageDialog(null,"Você ainda é menor de idade");
        } else {
            JOptionPane.showMessageDialog(null,"Você é maior de idade");
        }

        System.out.println((idade <= 18) ? "Menor de idade" : "Maior de idade");
    }
}
