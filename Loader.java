import java.util.ArrayList;
import java.util.List;

class Product {
    private int weight;
    private String name;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }
}

class Warehouse {
    private List<Product> products;
    private int nabrWeight = 0;
    private boolean ready = false;

    public Warehouse(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public synchronized Product takeProduct() {
        if (products.isEmpty()) {
            return null;
        }
        Product product = products.get(0);
        
        if (nabrWeight + product.getWeight() > 150) {
            ready = true;
            return null;
        }
        
        products.remove(0);
        nabrWeight += product.getWeight();
        return product;
    }

    public synchronized boolean isEmpty() {
        return products.isEmpty();
    }

    public synchronized int getNabrWeight() {
        return nabrWeight;
    }
    
    public synchronized boolean isReady() {
        return ready;
    }
    
    public synchronized int sendAndReset() {
        int sendWeight = nabrWeight;
        nabrWeight = 0;
        ready = false;
        return sendWeight;
    }
}

class Loader extends Thread {
    private Warehouse Warehouse;
    private static Object lock = new Object();

    public Loader(Warehouse warehouse) {
        this.Warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            if (Warehouse.isEmpty()) {
                break;
            }
            
            Product product = Warehouse.takeProduct();
            if (product == null) {
                synchronized (lock) {
                    if (Warehouse.isReady() && Warehouse.getNabrWeight() > 0) {
                        int weight = Warehouse.sendAndReset();
                        System.out.println(Thread.currentThread().getName() + ": left with - " + weight);
                    }
                }
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                continue;
            }

            synchronized (lock) {
                if (Warehouse.isReady() && Warehouse.getNabrWeight() > 0) {
                    int weight = Warehouse.sendAndReset();
                    System.out.println(Thread.currentThread().getName() + ": left with - " + weight);
                }
            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        synchronized (lock) {
            if (Warehouse.getNabrWeight() > 0) {
                int weight = Warehouse.sendAndReset();
                System.out.println(Thread.currentThread().getName() + ": left with - " + weight);
            }
        }
    }


    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("1", 20));
        products.add(new Product("2", 30));
        products.add(new Product("3", 50));
        products.add(new Product("4", 40));
        products.add(new Product("5", 60));
        products.add(new Product("6", 25));
        products.add(new Product("7", 35));
        products.add(new Product("8", 45));
        products.add(new Product("9", 55));
        products.add(new Product("10", 15));
        products.add(new Product("11", 50));
        products.add(new Product("12", 40));
        products.add(new Product("13", 60));
        products.add(new Product("14", 25));
        products.add(new Product("15", 35));
        products.add(new Product("16", 45));
        products.add(new Product("17", 55));
        products.add(new Product("18", 15));
        
        Warehouse warehouse = new Warehouse(products);

        Loader loader1 = new Loader(warehouse);
        Loader loader2 = new Loader(warehouse);
        Loader loader3 = new Loader(warehouse);

        loader1.start();
        loader2.start();
        loader3.start();

        try {
            loader1.join();
            loader2.join();
            loader3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("complete");
    }
}