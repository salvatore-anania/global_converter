package Conversion;

public class Decimal {

    public static String convertToDecimal(String str) {
        String decimalString = "d";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int decimalValue = (int) ch;
            if(i!=str.length()-1){
                decimalString += decimalValue + "|";
            }else{
                decimalString += decimalValue;
            }
        }

        return decimalString.trim();
    }

    public static String convertToText(String decimal) {
        String[] decimalValues = decimal.split("\\|");
        String text = "";

        for (String decimalValue : decimalValues) {
            int charValue = 0;

            for (int i = 0; i < decimalValue.length(); i++) {
                char digit = decimalValue.charAt(i);
                charValue = charValue * 10 + (digit - '0');
            }

            text += (char) charValue;
        }

        return text;
    }
    
}
