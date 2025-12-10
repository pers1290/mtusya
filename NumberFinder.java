import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "AAA 23 bb 2.4 5";
        
        try {
            Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");
            Matcher matcher = pattern.matcher(text);
             
            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            
        } catch (PatternSyntaxException e) {
 System.out.println(e.getMessage());
        }
    }
}