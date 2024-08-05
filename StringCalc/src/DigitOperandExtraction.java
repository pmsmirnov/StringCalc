import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DigitOperandExtraction {
    public static int DigitOperandExtract (String inputString){
        Pattern patternNumber = Pattern.compile("(([1-9])|10)$");
        Matcher matcherNumber = patternNumber.matcher(inputString);
        int number=-1;
        if (matcherNumber.find()) {
            try
            {
                number = Integer.parseInt((matcherNumber.group()).trim());    //String преобразуется в int
                //System.out.println("Операнд 2 числовой: " + number);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
        return number;
    }
}
