import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
        hw1();
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


}


    Напишите функцию printPrimeNums, которая выведет на экран все простые числа в промежутке от 1 до 1000, каждое на новой строке.