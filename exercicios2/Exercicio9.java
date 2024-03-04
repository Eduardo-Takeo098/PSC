package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio9 {
    public static void main(String[] args) {
        String nome, sexoInput;
        int idade;

        nome = JOptionPane.showInputDialog("Digite seu nome: ");
        idade = Integer.parseInt(JOptionPane.showInputDialog("Digite sua idade: "));
        
        sexoInput = JOptionPane.showInputDialog("Digite seu sexo (Macho/Fêmea): ");
        char sexo = sexoInput.toUpperCase().charAt(0);

        boolean aceita = (sexo == 'F') && (idade < 25);

        if (aceita) {
            JOptionPane.showMessageDialog(null, nome + " ACEITA");
        } else {
            JOptionPane.showMessageDialog(null, nome + " NÂO ACEITA");    
        }
        
    }
}
