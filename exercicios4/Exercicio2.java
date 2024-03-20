public class Exercicio2 {
    public static void main(String[] args) {
        
        for (int i = 1; i <= 40; i++) {
            if (i % 4 == 0 || i % 10 == 0){
                System.out.println("PIM");
            } else {
                System.out.println(i);
            }
        }
    }
}