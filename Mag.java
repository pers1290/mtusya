import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Product {
    String name;
    double price;
    
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class Mag {
    private ArrayList<Product> list = new ArrayList<>();
    
    public void addProduct(String name, double price) {
        list.add(new Product(name, price));
        System.out.println(name + "-add");
    }
    
    public void showProducts() {
        if (list.isEmpty()) {
            System.out.println("Null");
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);
            System.out.println((i+1) + " " + p.name + "-" + p.price);
        }
    }
    
    public double Sales() {
        double sale = 0;
        for (Product p : list) {
            sale += p.price;
        }
        return sale;
    }

    public String findPopular() {
        if (list.isEmpty()) {
            return "Null";
        }
        
        HashMap<String, Integer> t = new HashMap<>();

        for (Product p : list) {
            t.put(p.name, t.getOrDefault(p.name, 0) + 1);
        }
        
        String best = "";
        int maxC = 0;
        
        for (Map.Entry<String, Integer> entry : t.entrySet()) {
            if (entry.getValue() > maxC) {
                maxC = entry.getValue();
                best = entry.getKey();
            }
        }
        
        return best;
    }
    

    public static void main(String[] args) {
       Mag mag = new Mag();

        mag.addProduct("a", 50.0);
        mag.addProduct("b", 80.0);
        mag.addProduct("c", 50.0);
        mag.addProduct("d", 200.0);
        mag.addProduct("b", 80.0);
        mag.addProduct("b", 80.0);
        mag.addProduct("c", 50.0);
        
        mag.showProducts();
        System.out.println(mag.Sales());
        System.out.println(mag.findPopular());
    }
}