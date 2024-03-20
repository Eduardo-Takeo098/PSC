import javax.swing.JOptionPane;

public class Exercicio1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite um número inteiro:"));

        for(int i = 1; i <= n; i++){
            System.out.println(Math.pow(i, 2));
        }
    }
}