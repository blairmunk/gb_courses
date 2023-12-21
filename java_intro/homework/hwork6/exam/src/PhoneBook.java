import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    // Создаем HashMap для хранения имен и списков номеров телефонов
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    // Метод для добавления записи в телефонную книгу
    public void add(String name, Integer phoneNum) {
        // Если запись с именем уже существует, добавляем новый номер телефона в существующую запись
        // Иначе создаем новую запись с этим именем и номером телефона
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNum);
        } else {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(phoneNum);
            phoneBook.put(name, numbers);
        }
    }

    // Метод для поиска номеров телефона по имени в телефонной книге
    public ArrayList<Integer> find(String name) {
        // Возвращает список номеров телефона для этой записи, если она существует
        // Иначе возвращает пустой список
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    // Метод для получения всей телефонной книги в виде HashMap
    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }
}