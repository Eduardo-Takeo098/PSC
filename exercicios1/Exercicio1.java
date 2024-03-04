package exercicios1;

import javax.swing.JOptionPane;

public class Exercicio1 {
    public static void main(String[] args) {
        double cotDolar, quantDolar, convert;

        cotDolar = 4.93;
        quantDolar = Double.parseDouble(JOptionPane.showInputDialog("Quantos dólares você têm? "));

        convert = quantDolar * cotDolar;
        JOptionPane.showMessageDialog(null, "Em real você tem: " + convert);
    }
}
