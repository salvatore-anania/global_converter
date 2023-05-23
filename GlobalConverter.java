
import java.util.Scanner;

import Conversion.Binary;
import Conversion.Decimal;
import Conversion.Hexadecimal;
import Conversion.Octal;
import Conversion.Text;
import Conversion.ChiffrementCesar;

public class GlobalConverter {
    
    // fonction pour tester les caractere Ascii
    public static boolean containsOnlyAscii(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) > 127) {
                return false;
            }
        }
        return true;
    }

    // fonction pour tester la base entrée
    public static boolean testBase(String base) {
        if(base.equals("hexadecimal") || base.equals("-h")){
            return true;
        }else if(base.equals("octal") || base.equals("-o")){
            return true;
        }else if(base.equals("decimal") || base.equals("-d")){
            return true;
        }else if(base.equals("binary") || base.equals("-b")){
            return true;
        }else if(base.equals("text") || base.equals("-t")){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String base = args[0],traduire = args[1],chiffrement = null;
        int decalage=0;

        if(args.length>3)
        {
            chiffrement = args[2];
            decalage = Integer.parseInt(args[3]);
        }


        try (Scanner myObj = new Scanner(System.in)) {
            // test tant que la phrase n'est pas formé de caractere Ascii seulement
            while(!containsOnlyAscii(traduire)){
                System.out.println("Entrez une chaine de caractere valide a convertir :");
                traduire =myObj.nextLine();
            }
            // test tant que la base n'est pas valide
            while(!testBase(base)){
                System.out.println("Entrez une base valide dans laquelle convertir (hexadecimal,octal,decimal,binary ou text) :");
                base =myObj.nextLine();
            }
        }
        /*applique le chiffrement si demandé par l'utilisateur et si la base de départ est un texte
        sinon le chiffrement sera appliqué aprés transformation en base texte*/
        if(chiffrement!=null && !base.equals("text") && !base.equals("-t")){
            traduire=ChiffrementCesar.encrypt(traduire, decalage);
        }
        
        // convertit dans la base voulus
        if(base.equals("hexadecimal") || base.equals("-h")){
            System.out.println(Hexadecimal.convertToHex(traduire));

        }else if(base.equals("octal") || base.equals("-o")){
            System.out.println(Octal.convertToOctal(traduire));

        }else if(base.equals("decimal") || base.equals("-d")){
            System.out.println(Decimal.convertToDecimal(traduire));
            
        }else if(base.equals("binary") || base.equals("-b")){
            System.out.println(Binary.convertToBinary(traduire));

        }else if(base.equals("text") || base.equals("-t")){
            traduire = Text.convertToText(traduire);
            // applique le chifrement sur la string traduite afin de n'avoir qu'un seul code de chiffrement au lieu d'un par base
            if(chiffrement!=null){
                traduire=ChiffrementCesar.encrypt(traduire, decalage);
            }
            // affiche le texte traduit et chiffrer si demandé
            System.out.println(traduire);
        }
    }

}
