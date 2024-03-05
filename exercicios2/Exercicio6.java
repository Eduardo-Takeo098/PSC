package exercicios2;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class Exercicio6 {
    public static void main(String[] args) {
        double[] listNum = new double[3];
        
        listNum[0]  = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número: "));
        listNum[1]  = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número: "));
        listNum[2]  = Double.parseDouble(JOptionPane.showInputDialog("Digite o terceiro número: "));
        
        Arrays.sort(listNum);

        JOptionPane.showMessageDialog(
            null, "Os números ordenados de forma crescente são: ");
        
        for (double numero : listNum) {
            JOptionPane.showMessageDialog(null, numero);
        } 
    }
}
