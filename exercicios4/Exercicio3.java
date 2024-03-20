import javax.swing.JOptionPane;

public class Exercicio3 {
    public static void main(String[] args) {
        double n = Double.parseDouble(JOptionPane.showInputDialog("Digite um número: "));
        double soma = 0;

        for(double k = 1; k <= n; k++){
            soma = soma + (1/k);
        }
        
        System.out.println(soma);
    } 
}