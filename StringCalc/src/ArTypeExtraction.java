import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArTypeExtraction {
    public static char ArTypeExtract (String inputString){
        char arType = ' ';
        Pattern patternArType = Pattern.compile("[+-/*]");   // блок извлечения арифметической операции
        String tempString = inputString.replaceAll("^\".+?\"", "");// убираем выражение в кавычках в начале строки чтобы в операнде тоже могли быть символы мат. операций
        tempString = tempString.replaceAll("\".+\"$", ""); // убираем в конце строки
        Matcher matcherArType = patternArType.matcher(tempString);  // в оставшейся строке ищем знак математической операции
        if (matcherArType.find()) {
            arType = (matcherArType.group()).charAt(0);
            //System.out.println("Арифметическая операция: " + arType);
        }
        return arType;
    }
}
