
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmail {

    private static final String prototype = "\\w+@\\w+.[a-z]{2,}";
    private static final Pattern pattern = Pattern.compile(prototype);

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, input e-mail");
        Matcher matcher = pattern.matcher(reader.readLine());
        if (matcher.find()) {
            System.out.println();
            System.out.println("Correct e-mail");
        } else {
            System.out.println();
            System.out.println("Incorrect e-mail");
        }
    }
}
