package exercicios2;

import javax.swing.JOptionPane;

public class Exercicio8 {
    public static void main(String[] args) {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Digite um número"));
        String mensagem;
        
        switch (num) {
            case 20:
                JOptionPane.showMessageDialog(null, "Igual a 20");;
                break;

            default:
                mensagem = (num > 20) ? "Maior que 20" : "Menor que 20";
                JOptionPane.showMessageDialog(null, mensagem);
                break;

        }
    }
}