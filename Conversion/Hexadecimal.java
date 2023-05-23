package Conversion;

public class Hexadecimal {

    public static String convertToHex(String str) {
        String hexString = "";
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String hex = String.format("%02X", (int) ch);
            if(i!=str.length()-1){
                hexString += hex + "|";
            }else{
                hexString += hex;
            }
        }
        
        return hexString;
    }

    public static String convertToText(String hex) {
        String ascii = "h";

        for (int i = 0; i < hex.length(); i += 3) {
            String hexPair = hex.substring(i, i + 2);
            int decimalValue = hexToDecimal(hexPair);
            char ch = (char) decimalValue;
            ascii += ch;
        }

        return ascii;
    }

    public static int hexToDecimal(String hex) {
        int decimalValue = 0;

        for (int i = 0; i < hex.length(); i++) {
            char ch = hex.charAt(i);
            int digitValue = ch - '0';
            if (digitValue > 9) {
                digitValue = ch - 'A' + 10;
            }
            decimalValue = decimalValue * 16 + digitValue;
        }

        return decimalValue;
    }
}
