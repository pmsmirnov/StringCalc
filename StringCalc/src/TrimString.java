public class TrimString {
    public static String Trim(StringBuilder resultStringBuilder, int trimCount){  // ������� ������ � ����������� �������
        if (resultStringBuilder.length()>trimCount){
            return "\"" + resultStringBuilder.substring(0, trimCount) + "...\""; //�������, ��� � ���������� ������ ������� <40 � �� <=40
        }
        else {
            return "\"" + resultStringBuilder + "\"";
        }
    }
}
