package hazi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Titkosit {

    public static void main(String[] args) throws IOException {

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

        String line = null;

        BufferedReader inFile = new BufferedReader(new FileReader(args[0]));
        try {
            line = inFile.readLine();
            if (line == null) {
                System.out.println("Nem adtál meg titkosítani kívánt szót a szöveges állományban!");
            } else {
                for(int i = 0; i<line.length(); i++) {
                    if (line.charAt(i) == 'z') {
                        System.out.print("a");
                    } else if (dictionary.containsKey(line.charAt(i))) {
                        int b = dictionary.get(line.charAt(i))+1;
                        System.out.print((char) b);
                    } else if (line.charAt(i) == ' ') {
                        System.out.print(' ');
                    } else {
                        int a = line.charAt(i) + 1;
                        System.out.print((char) a);
                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Hiba történt!");
        }
        inFile.close();
    }
}
