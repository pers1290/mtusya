import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream a = new FileInputStream("a.txt");
             FileOutputStream b = new FileOutputStream("b.txt")) {
            
            int c;
            while ((c = a.read()) != -1) {
                b.write(c);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}