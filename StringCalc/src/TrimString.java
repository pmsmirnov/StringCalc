public class TrimString {
    public static String Trim(StringBuilder resultStringBuilder, int trimCount){  // обрезка строки и навешивание кавычек
        if (resultStringBuilder.length()>trimCount){
            return "\"" + resultStringBuilder.substring(0, trimCount) + "...\""; //полагаю, что в реализации метода условие <40 а не <=40
        }
        else {
            return "\"" + resultStringBuilder + "\"";
        }
    }
}
