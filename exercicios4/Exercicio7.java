import javax.swing.JOptionPane;

public class Exercicio7 {
    public static void main(String[] args) {
        String[] listDia = new String[7];

        listDia[0]  = "Segunda";
        listDia[1]  = "Terça";
        listDia[2]  = "Quarta";
        listDia[3]  = "Quinta";
        listDia[4]  = "Sexta";
        listDia[5]  = "Sabado";
        listDia[6]  = "Domingo";
        
        int maiorVenda = 0;
        int diaMaximo = 0;
        
        for(int i=0; i <= 6; i++){
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Anote a quantidade de livros vendidos: " + listDia[i]));
            if (quantidade > maiorVenda){
                maiorVenda = quantidade;
                diaMaximo = i;
            }
        } System.out.println("O dia com a maior venda foi: " + listDia[diaMaximo] + "\n" +  "Com " + maiorVenda + " livros vendidos");
    }
}
