package Conversion;


public class Text {
    public static String convertToText(String str) {
        String traduit="";
        if(str.charAt(0)=='h'){
            traduit= Hexadecimal.convertToText(str.substring(1));
        }else if(str.charAt(0)=='o'){
            traduit= Octal.convertToText(str.substring(1));
        }else if(str.charAt(0)=='d'){
            traduit= Decimal.convertToText(str.substring(1));
        }else if(str.charAt(0)=='b'){
            traduit= Binary.convertToText(str.substring(1));
        }
        return traduit;
    }
}
