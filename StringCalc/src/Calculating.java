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
                    throw new StringCalcException("������������ �������� ��������. � ������ ������ ��������� �����");
                }
                break;
            case ('-'):
                if(secondOperandType){
                    Pattern patternSubtraction = Pattern.compile(wordOperand[1] + "$"); // �������� ��������� � ����� ������ ������� ��������
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
                    throw new StringCalcException("������������ �������� ���������. �� ������ ������ �������� �����");
                }
                break;
            case ('*'):
                if(secondOperandType){
                    throw new StringCalcException("������������ �������� ���������. ������ ������ �������� �� ������");
                }
                else {
                    resultStringBuilder.append(String.valueOf(wordOperand[0]).repeat(number)); // ���� �������� ������, IDE ���������� ����� �������, ����� �����������
                    //System.out.println(resultStringBuilder);
                }
                break;
            case('/'):
                if(secondOperandType){
                    throw new StringCalcException("������������ �������� �������. ������ ������ �������� �� ������");
                }
                else{
                    if(wordOperand[0].length()%number == 0){ //���� ���������� �������� � ������ ����� ������� �� �����, �� �����
                        resultStringBuilder.append(wordOperand[0].subSequence(0, wordOperand[0].length()/number));
                        //System.out.println(resultStringBuilder);
                    }
                    else{
                        throw new StringCalcException("������������ �������� �������. ���������� �������� � ������ �� ������� ��� �������");
                    }
                }
                break;

        }
        return resultStringBuilder;
    }

}
