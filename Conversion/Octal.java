package Conversion;

public class Octal {
    
    public static String convertToOctal(String text) {
        String octalString = "o";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            int charValue = (int) ch;
            String octalValue = "";

            while (charValue > 0) {
                int remainder = charValue % 8;
                octalValue = remainder + octalValue;
                charValue /= 8;
            }

            if(i!=text.length()-1){
                octalString += octalValue + "|";
            }else{
                octalString += octalValue;
            }
        }

        return octalString.trim();
    }

    public static String convertToText(String octal) {
        String[] octalValues = octal.split("\\|");
        String text = "";

        for (String octalValue : octalValues) {
            int charValue = 0;

            for (int i = 0; i < octalValue.length(); i++) {
                char digit = octalValue.charAt(i);
                int octalDigit = Character.getNumericValue(digit);

                charValue = (charValue << 3) | octalDigit;
            }

            text += (char) charValue;
        }

        return text;
    }

}
