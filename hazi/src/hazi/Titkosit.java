package hazi;

import java.util.HashMap;
import java.util.Map;

public class Titkosit {

    public static void main(String[] args) {

        Map<Character, Character> dictionary = new HashMap<Character, Character>();
        dictionary.put('á', 'a');
        dictionary.put('é', 'e');
        dictionary.put('í', 'i');
        dictionary.put('ó', 'o');
        dictionary.put('ö', 'o');
        dictionary.put('ő', 'ö');
        dictionary.put('ú', 'u');
        dictionary.put('ü', 'u');
        dictionary.put('ű', 'u');

        if (args.length == 0) {
            System.out.println("Nem adtál meg titkosítani kívánt szót!");
        } else {
            for(int i = 0; i<args[0].length(); i++) {
                if (args[0].charAt(i) == 'z') {
                    System.out.print("a");
                } else if (dictionary.containsKey(args[0].charAt(i))) {
                    int b = dictionary.get(args[0].charAt(i))+1;
                    System.out.print((char) b);
                } else {
                    int a = args[0].charAt(i) + 1;
                    System.out.print((char) a);
                }

            }
        }
    }
}
