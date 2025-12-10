import java.util.regex.*;

public class WordFinder {
    public static void main(String[] args) {
        String text = "Aa Bbb bb AA ba aab";
        
        String w = "a";

        try {
            String regex = "\\b[" + w.toLowerCase() + w.toUpperCase() + "][a-zA-Z]*\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);

            while (matcher.find()) {
                System.out.println(matcher.group());
            }
            
        } catch (PatternSyntaxException e) {
            System.out.println(e.getMessage());
        } 
    }
}