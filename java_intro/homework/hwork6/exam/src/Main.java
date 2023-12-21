import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        // Проверяем наличие аргументов командной строки
        if (args.length == 0) {
            // Устанавливаем значения по умолчанию
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            // Получаем значения из аргументов командной строки
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        // Создаем экземпляр телефонной книги
        PhoneBook myPhoneBook = new PhoneBook();
        // Добавляем записи в телефонную книгу
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add("Petrov", 76667875);
        myPhoneBook.add("Petrov", 76667215);
        myPhoneBook.add("Morozov", 76661115);

        // Сортируем телефонную книгу по убыванию числа телефонов
        Map<String, ArrayList<Integer>> sortedPhoneBook = new HashMap<>(myPhoneBook.getPhoneBook());
        sortedPhoneBook.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> System.out.println(e.getKey() + "=" + e.getValue()));

        // Выводим результат поиска
        System.out.println(myPhoneBook.find("Sidorov"));
    }
}

