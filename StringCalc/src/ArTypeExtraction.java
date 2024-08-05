import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArTypeExtraction {
    public static char ArTypeExtract (String inputString){
        char arType = ' ';
        Pattern patternArType = Pattern.compile("[+-/*]");   // ���� ���������� �������������� ��������
        String tempString = inputString.replaceAll("^\".+?\"", "");// ������� ��������� � �������� � ������ ������ ����� � �������� ���� ����� ���� ������� ���. ��������
        tempString = tempString.replaceAll("\".+\"$", ""); // ������� � ����� ������
        Matcher matcherArType = patternArType.matcher(tempString);  // � ���������� ������ ���� ���� �������������� ��������
        if (matcherArType.find()) {
            arType = (matcherArType.group()).charAt(0);
            //System.out.println("�������������� ��������: " + arType);
        }
        return arType;
    }
}
