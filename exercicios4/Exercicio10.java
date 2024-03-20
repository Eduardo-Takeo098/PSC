import java.util.Scanner;

public class Exercicio10 {

    public static void main(String[] args) {
        Scanner conta = new Scanner(System.in);
        System.out.println("Digite os coeficientes a, b e c de uma equação de segundo grau na forma ax^1 + bx + c = 0");
        double a = conta.nextDouble();
        double b = conta.nextDouble();
        double c = conta.nextDouble();
        double delta = (b * b) - 4 * a * c;
        double raiz1 = (-b + Math.sqrt(delta)) / (2 * a);
        double raiz2 = (-b - Math.sqrt(delta)) / (2 * a);
        System.out.println(raiz1 + ", " + raiz2);
        conta.close();
    }
}