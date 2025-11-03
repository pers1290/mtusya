import java.util.LinkedList;

class Entry<K, V>{
    private K key;
    private V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }

    public void setValue(V value){
        this.value = value;
    }
}


class MyTable<K, V> {
    private int size;
    private static final int c = 16;
    private LinkedList<Entry<K, V>>[] table;

    public MyTable(){
        table = new LinkedList[c];
        size = 0;
    }

    private int hash(K key){
        return key.hashCode() % table.length;
    }

    public void put(K key, V value){
        int index = hash(key);
        if (table[index] == null){
            table[index] = new LinkedList<Entry<K, V>>();
        }

        for (Entry<K, V> entry : table[index]){
            if (entry.getKey().equals(key)){
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<K, V>(key, value));
        size++;
    }

    public V get(K key){
        int index = hash(key);
        if (table[index] != null){
            for (Entry<K, V> entry : table[index]){
                if (entry.getKey().equals(key)){
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key){
        int index = hash(key);
        if (table[index] != null){
            for (Entry<K, V> entry : table[index]){
                if (entry.getKey().equals(key)){
                    table[index].remove(entry);
                    size--;
                }
            }
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
}


public class MyHash{
    public static void main(String[] args){
        MyTable a = new MyTable<>();
        System.out.println(a.isEmpty());

        a.put("a", 5);
        a.put("b", 7);
        a.put("c", 3);

        System.out.println(a.get("a"));
        a.put("a", 8);
        System.out.println(a.get("a"));

        a.remove("b");
        System.out.println(a.get("b"));

        System.out.println(a.size());
        System.out.println(a.isEmpty());
    }
}
