import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculating {
    public static StringBuilder Calc(String[] wordOperand, boolean secondOperandType, int number, char arType) throws StringCalcException{
        StringBuilder resultStringBuilder = new StringBuilder();
        switch (arType){
            case ('+'):
                if (secondOperandType){
                    resultStringBuilder.append(wordOperand[0]);
                    resultStringBuilder.append(wordOperand[1]);
                    //System.out.println(resultStringBuilder);
                }
                else {
                    throw new StringCalcException("Ќедопустима€ операци€ сложени€.   строке нельз€ прибавить число");
                }
                break;
            case ('-'):
                if(secondOperandType){
                    Pattern patternSubtraction = Pattern.compile(wordOperand[1] + "$"); // проверка вхождени€ в конце строки первого операнда
                    Matcher matcherSubtraction = patternSubtraction.matcher(wordOperand[0]);
                    if (matcherSubtraction.find()){
                        resultStringBuilder.append((wordOperand[0]).replaceAll(wordOperand[1], ""));
                    }
                    else {
                        resultStringBuilder.append(wordOperand[0]);
                    }
                    //System.out.println(resultStringBuilder);
                }
                else {
                    throw new StringCalcException("Ќедопустима€ операци€ вычитани€. »з строки нельз€ вычитать число");
                }
                break;
            case ('*'):
                if(secondOperandType){
                    throw new StringCalcException("Ќедопустима€ операци€ умножени€. —троку нельз€ умножить на строку");
                }
                else {
                    resultStringBuilder.append(String.valueOf(wordOperand[0]).repeat(number)); // было написано циклом, IDE предложила такой вариант, нужно разобратьс€
                    //System.out.println(resultStringBuilder);
                }
                break;
            case('/'):
                if(secondOperandType){
                    throw new StringCalcException("Ќедопустима€ операци€ делени€. —троку нельз€ поделить на строку");
                }
                else{
                    if(wordOperand[0].length()%number == 0){ //если количество символов в строке ровно делитс€ на число, то делим
                        resultStringBuilder.append(wordOperand[0].subSequence(0, wordOperand[0].length()/number));
                        //System.out.println(resultStringBuilder);
                    }
                    else{
                        throw new StringCalcException("Ќедопустима€ операци€ делени€.  оличество символов в строке не делитс€ без остатка");
                    }
                }
                break;

        }
        return resultStringBuilder;
    }

}
