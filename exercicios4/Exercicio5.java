import javax.swing.JOptionPane;

public class Exercicio5 {
    public static void main(String[] args) {
        int contador = 0;
        int n = Integer.parseInt(JOptionPane.showInputDialog("Digite um número:"));
        //a e b são catetos, c é a hipotenusa
        for(int c = 1; c <= n; c++){
            boolean achou = false;
            for(int a = 1; a < c && !achou; a++){
                int b = a;
                while(a*a + b*b < c*c){
                    b++;
                }
                if(a*a + b*b == c*c){
                    achou = true;
                    contador++;
                    System.out.println("#"+contador+": cateto1 = " + a + ", cateto2 = " + b + ", hipotenusa = " + c);
                }
            }
        }
    }
    
}