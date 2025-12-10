import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        // указываем путь к файлу
        String filePath = "a.txt";
        
        // создаем объект File
        File file = new File(filePath);
        
        // создаем объект Scanner для чтения файла
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
        // создаем объект Map для хранения слов и их количества
        Map<String, Integer> wordCount = new HashMap<>();
        
        // читаем файл по словам и добавляем их в Map
        while (scanner.hasNext()) {
            String word = scanner.next().toLowerCase(); 
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        
        // закрываем Scanner
        scanner.close();
        
        // создаем список из элементов Map
        List<Map.Entry<String, Integer>> list = new ArrayList<>(wordCount.entrySet());
        
        // сортируем список по убыванию количества повторений
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        // выводим топ-10 слов
        System.out.println("Top-10:");
        
        int count = Math.min(10, list.size());
        for (int i = 0; i < count; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println((i + 1)+ " "  + entry.getKey() + " " + entry.getValue());
        }
    }
}