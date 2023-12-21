import javax.swing.*;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        hw2();
    }

    static void hw1() {
        //          Вычислить n-ое треугольного число(сумма чисел от 1 до n).

        System.out.print("Input your number: ");
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int triangleNum = 0;

        for (int i = 0; i <= n; i++){
            triangleNum += i;
        }
        System.out.print(triangleNum);
    }

    static void hw2() {
//        Напишите функцию printPrimeNums, которая выведет на экран все простые
//        числа в промежутке от 1 до 1000, каждое на новой строке.
        for (int i = 2; i <= 1000; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= i/2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) System.out.println(i);;
        }


    }

    public int calculate(char op, int a, int b) {
        double result;
        switch (op) {
            case ('+'):
                return  a + b;

            case ('-'):
                return  a - b;
            case ('*'):
                return a * b;
            case ('/'):
                result = (double) a / (double) b;
                return (int) result;
            default:
                System.out.print("Некорректный оператор: ");
                System.out.println(op);
        }


    return 0;
    }

}

