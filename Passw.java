import java.util.regex.*;
import java.util.Scanner;

public class Passw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        
        try {
            String regex = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(password);
            
            if (matcher.matches()) {
                System.out.println("Ok");
            } else {
                System.out.println("Error");
            }           
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        } 
    }
}