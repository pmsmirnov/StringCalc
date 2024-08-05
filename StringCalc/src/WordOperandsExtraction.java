import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordOperandsExtraction {
    public static String[] WordOperandsExtract (String regex, String inputString){
        Pattern patternWord = Pattern.compile(regex);        // блок извлечения операндов-строк
        Matcher matcherWord = patternWord.matcher(inputString);
        String [] wordOperand = {"", ""};
        int wordCounter = 0;
        while(matcherWord.find()){
            wordOperand[wordCounter] = (matcherWord.group()).replaceAll("\"","" );
            //System.out.println("Операнд " + (wordCounter+1) + ":" + wordOperand[wordCounter]);
            wordCounter++;
        }
        return wordOperand;
    }

}
