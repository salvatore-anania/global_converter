package Conversion;

public class Octal {
    
    public static String convertToOctal(String str) {
        String octalString = "o";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String octal = Integer.toOctalString((int) ch);
            if(i!=str.length()-1){
                octalString += octal + "|";
            }else{
                octalString += octal;
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
