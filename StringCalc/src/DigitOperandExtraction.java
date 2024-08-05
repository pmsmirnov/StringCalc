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
                number = Integer.parseInt((matcherNumber.group()).trim());    //String ������������� � int
                //System.out.println("������� 2 ��������: " + number);
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("NumberFormatException: " + nfe.getMessage());
            }
        }
        return number;
    }
}
