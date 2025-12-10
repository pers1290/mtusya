import java.util.regex.*;
import java.util.Scanner;

public class IPAddress {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ipAddress = scanner.nextLine();
        
        try {
            String regex = "^((25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9])\\.){3}"
                         + "((25[0-5]|2[0-4][0-9]|[0-1][0-9][0-9]|[0-9][0-9]|[0-9]))$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(ipAddress);
            
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