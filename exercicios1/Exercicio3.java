package exercicios1;

import javax.swing.JOptionPane;

public class Exercicio3 {
    public static void main(String[] args) {
        double precoUnitario, quantVendido;
        
        quantVendido = Double.parseDouble(JOptionPane.showInputDialog(
            "Qual foi a quantidade vendida? "));
        precoUnitario = Double.parseDouble(JOptionPane.showInputDialog(
            "Qual o preço das peças vendidas? "));
        
        JOptionPane.showMessageDialog(
            null, "O seu pagamento das vendas foi: " + ((quantVendido * precoUnitario) * 0.05));
    }
}
