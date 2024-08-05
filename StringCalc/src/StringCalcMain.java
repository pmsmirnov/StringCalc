import java.util.Objects;
import java.util.Scanner;


public class StringCalcMain {

    public static void main(String[] args) throws StringCalcException {

        String [] wordOperand;
        boolean secondOperandType = true;             //true - ������, false - �����
        int number = -1;
        char arType;
        StringBuilder resultStringBuilder;
        Scanner in = new Scanner(System.in);
        System.out.print("Input: ");
        String inputString = in.nextLine();

        if (!CheckInput.Check("^(\".{1,10}\")\s*[-+/*]\s*((\".{1,10}\")|(([1-9])|10))$", inputString)){  //�������� ������������ ������ ��������
            throw new StringCalcException("��������� �� ������������� ��������");
       }

        wordOperand = WordOperandsExtraction.WordOperandsExtract("\".+?\"", inputString);  // ��������� ��������� ���������

        if (Objects.equals(wordOperand[1], "")){                                              // ���� ���������� ��������-�����
            number = DigitOperandExtraction.DigitOperandExtract(inputString);
            if (number != -1) {
                secondOperandType = false;
            }
        }

        arType = ArTypeExtraction.ArTypeExtract(inputString); // ���������� �������������� ��������

        resultStringBuilder = Calculating.Calc(wordOperand, secondOperandType, number, arType); // �����������

        System.out.println("Result: " + TrimString.Trim(resultStringBuilder, 40)); // ������� ������ � ����� ����������
    }

}