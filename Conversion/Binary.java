package Conversion;

public class Binary {

    public static String convertToBinary(String str) {
        String binaryString = "b";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String binary = decimalToBinary((int) ch);
            if(i!=str.length()-1){
                binaryString += binary + "|";
            }else{
                binaryString += binary;
            }
        }

        return binaryString.trim();
    }

    public static String decimalToBinary(int decimal) {
        String binary = "";

        while (decimal > 0) {
            int rem = decimal % 2;
            binary = rem + binary;
            decimal = decimal / 2;
        }
        if(binary.length()<8){
            binary = '0' + binary;
        }

        return binary;
    }

    public static String convertToText(String octal) {
        String[] octalValues = octal.split("\\s+");
        String text = "";

        for (String octalValue : octalValues) {
            int charValue = 0;

            for (int i = 0; i < octalValue.length(); i++) {
                char digit = octalValue.charAt(i);
                charValue = charValue * 8 + (digit - '0');
            }

            text += (char) charValue;
        }

        return text;
    }
}
