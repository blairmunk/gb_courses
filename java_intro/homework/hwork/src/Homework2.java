import java.io.File;
        import java.io.FileWriter;
        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.io.IOException;
        import java.util.Arrays;
        import java.text.SimpleDateFormat;
        import java.util.Date;

class BubbleSort {
    private static File log;
    private static FileWriter fileWriter;


    public static void sort(int[] mas) {
        for (int out = mas.length - 1; out >= 1; out--){  //Внешний цикл
            for (int in = 0; in < out; in++){       //Внутренний цикл
                if(mas[in] > mas[in + 1]) {
                    int temp = mas[in];
                    mas[in] = mas[in + 1];
                    mas[in + 1] = temp;
                }
            }
        }
        System.out.println("dsdsdaf");
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
public class Homework2{
    public static void main(String[] args) {
        int[] arr = {};

        if (args.length == 0) {
            // При отправке кода на Выполнение, вы можете варьировать эти параметры
            arr = new int[]{9, 4, 8, 3, 1};
        }
        else{
            arr = Arrays.stream(args[0].split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        BubbleSort ans = new BubbleSort();
        ans.sort(arr);

        try (BufferedReader br = new BufferedReader(new FileReader("log.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}