package Conversion;

public class ChiffrementCesar {
    public static String encrypt(String coder, int decalage) {
        String aChiffrer = "";

        for (int i = 0; i < coder.length(); i++) {
            char ch = coder.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char encryptedChar = (char) ((ch - base + decalage) % 26 + base);
                aChiffrer += encryptedChar;
            } else {
                aChiffrer += ch;
            }
        }

        return aChiffrer;
    }

    public static String decrypt(String aChiffrer, int decalage) {
        String coder = "";

        for (int i = 0; i < aChiffrer.length(); i++) {
            char ch = aChiffrer.charAt(i);

            if (Character.isLetter(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                char decryptedChar = (char) (((ch - base - decalage) + 26) % 26 + base);
                coder += decryptedChar;
            } else {
                coder += ch;
            }
        }
        System.out.println(coder);
        return coder;
        
    }
}
