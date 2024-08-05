import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckInput {
    public static boolean Check (String regex, String inputString){
        Pattern patternAllInputString = Pattern.compile(regex);
        Matcher matcherAllInputString = patternAllInputString.matcher(inputString);
        return matcherAllInputString.matches();
}
}
