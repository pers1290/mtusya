abstract class Animal{
    protected String name;
    protected int age;
    private static int c = 0;

    public Animal() {
        this.name = "none";
        this.age = 0;
        c++;
    }

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
        c++;
    }

    public void info() {
        System.out.println("Name: " + name + "Age: " + age);
    }

    public abstract void move();
    public abstract void sound();

    public void eat() {
        System.out.println(name + " eat");
    }
    public void sleep() {
        System.out.println(name + " sleep");
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0){
            this.age = age;
        }
    }

    public static int getCount() {
        return c;
    }
}

class Cat extends Animal {
    private String poroda;
    private String color;

    public Cat() {
        super();
        this.poroda = "none";
        this.color = "none";
    }
    public Cat(String name, int age, String poroda, String color) {
        super(name, age);
        this.poroda = poroda;
        this.color = color;
    }

    @Override
    public void move() {
        System.out.println("hodit");
    }
    @Override
    public void sound() {
        System.out.println("meow");
    }

    @Override
    public void info() {
        System.out.println("Name: " + name + "Age: " + age + "Poroda: "+ poroda + "Color: " + color);
    }

    public void home() {
        System.out.println(name +" doma");
    }
    public void notHome() {
        System.out.println(name + " ne doma");
    }


    public String getPoroda() {
        return poroda;
    }
    public void setPoroda(String poroda) {
        this.poroda = poroda;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}


class Parrot extends Animal {
    private String size;
    private boolean canTolk;

    public Parrot() {
        super();
        this.size = "small";
        this.canTolk = false;
    }
    public Parrot(String name, int age, String size, boolean canTolk) {
        super(name, age);
        this.size = size;
        this.canTolk = canTolk;
    }

    @Override
    public void move() {
        System.out.println("letit");
    }
    @Override
    public void sound() {
        System.out.println("mb razgovarivaet");
    }

    @Override
    public void info() {
        System.out.println("Name: " + name + "Age: " + age + "size: " + size + "Tolk? " + canTolk);
    }

    public void fly() {
        System.out.println(name +" uletel");
    }

    public boolean getCanTolk() {
        return canTolk;
    }
    public void setCanTolk(boolean canTolk) {
        this.canTolk = canTolk;
    }

    public String getsize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
}


class Fish extends Animal {
    private boolean lives;
    private String exist;

    public Fish() {
        super();
        this.exist = "none";
        this.lives = true;
    }
    public Fish(String name, int age, String exist, boolean lives) {
        super(name, age);
        this.exist = exist;
        this.lives = lives;
    }

    @Override
    public void move() {
        System.out.println("plivet");
    }
    @Override
    public void sound() {
        System.out.println("molchit");
    }

    @Override
    public void info() {
        System.out.println("Name: " + name + "Age: " + age + "Home: " + exist + "lives? " + lives);
    }

    public void rost() {
        System.out.println(name +" rostet");
    }

    public String getExist() {
        return exist;
    }
    public void setExist(String exist) {
        this.exist = exist;
    }

    public boolean getLives() {
        return lives;
    }
    public void setLives(boolean lives) {
        this.lives = lives;
    }
}


public class laba2 {
    public static void main(String[] args) {
        Cat cat = new Cat("a", 10, "poroda", "black");
        Parrot parrot = new Parrot("b", 3, "malenkiy", true);
        Fish fish = new Fish("c", 2, "more", true);

        cat.info();
        parrot.info();
        fish.info();

        System.out.println("Cat name: " + cat.getName());
        cat.setName("aa");
        System.out.println("Cat name: " + cat.getName());

        cat.move();
        parrot.move();
        fish.move();

        System.out.println("klassov: " + Animal.getCount());
    }
}