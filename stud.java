import java.util.HashMap;
import java.util.Map;

class Student{
    private String name;
    private String fam;
    private int age;
    private double srball;
    
    public Student(String name, String fam, int age, double srball) {
        this.name = name;
        this.fam = fam;
        this.age = age;
        this.srball = srball;
    }

    public String getName(){ return name; }
    public String getFam(){ return fam; }
    public int getAge(){ return age; }
    public double getSrBall(){ return srball; }

    public void setName(String name){ this.name = name; }
    public void setFam(String fam){ this.fam = fam; }
    public void setAge(int age){ this.age = age; }
    public void setSrBall(double srball){ this.srball = srball; }

    public String info(){
        return "Name: " + name + " , Fam: " + fam + ", Age: " 
        + age + ", Ball: " + srball;
    }
}

class StudentHash {
    private Map<String, Student> studentMap;
    public StudentHash() {
        this.studentMap = new HashMap<>();
    }

    public String putStudent(String n, Student student){
        if (n == null || student == null){
            return "Error";
        }
        if (studentMap.containsKey(n)) {
            return "Error. no unique";
        } else {
            studentMap.put(n, student);
            return "Ok";
        }
    }

    public String findStudent(String n) {
        if (n == null){
            return "Error";
        }

        Student student = studentMap.get(n);
        if (student == null){
            return "Error. No student";
        } else {
            return student.info();
        }
    }

    public String delStudent(String n){
        if (n == null){
            return "Error";
        }
        Student student = studentMap.remove(n);
        if (student == null){
            return "Error";
        } else {
            return "Ok";
        }
    }

    public int getSize() {
        return studentMap.size();
    }
}

public class stud {
    public static void main(String[] args) {
        StudentHash studentDase = new StudentHash();

        Student student1 = new Student("A", "A", 20, 4.5);
        String res1 = studentDase.putStudent("0001", student1);
        System.out.println(res1);

        Student student2 = new Student("B", "B", 21, 4.8);
        String res2 = studentDase.putStudent("0002", student2);
        System.out.println(res2);

        Student student3 = new Student("C", "C", 22, 3.8);
        String res3 = studentDase.putStudent("0001", student3);
        System.out.println(res3);

        System.out.println(studentDase.findStudent("0001"));
        System.out.println(studentDase.findStudent("0001"));

        String del1 = studentDase.delStudent("0001");
        System.out.println(del1);

        System.out.println(studentDase.findStudent("0001"));        
    }
}