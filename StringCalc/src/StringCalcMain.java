import java.util.Objects;
import java.util.Scanner;


public class StringCalcMain {

    public static void main(String[] args) throws StringCalcException {

        String [] wordOperand;
        boolean secondOperandType = true;             //true - строка, false - число
        int number = -1;
        char arType;
        StringBuilder resultStringBuilder;
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String inputString = in.nextLine();

        if (!CheckInput.Check("^(\".{1,10}\")\s*[-+/*]\s*((\".{1,10}\")|(([1-9])|10))$", inputString)){  //проверка соответстви€ строки услови€м
            throw new StringCalcException("¬ыражение не соответствует услови€м");
       }

        wordOperand = WordOperandsExtraction.WordOperandsExtract("\".+?\"", inputString);  // получение строковых операндов

        if (Objects.equals(wordOperand[1], "")){                                              // блок извлечени€ операнда-числа
            number = DigitOperandExtraction.DigitOperandExtract(inputString);
            if (number != -1) {
                secondOperandType = false;
            }
        }

        arType = ArTypeExtraction.ArTypeExtract(inputString); // »звлечение арифметической операции

        resultStringBuilder = Calculating.Calc(wordOperand, secondOperandType, number, arType); // калькул€ци€

        System.out.println("Result: " + TrimString.Trim(resultStringBuilder, 40)); // обрезка строки и вывод результата
    }

}