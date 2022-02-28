package hazi;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

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

        StringTokenizer tokens = new StringTokenizer(args[0], ".", false);
        String filename = tokens.nextToken()+"_titkositott."+tokens.nextToken();

        BufferedWriter out = new BufferedWriter(new FileWriter(filename));

        try {
            line = inFile.readLine();
            if (line == null) {
                System.out.println("Nem adtál meg titkosítani kívánt szót a szöveges állományban!");
            } else {
                for(int i = 0; i<line.length(); i++) {
                    if (line.charAt(i) == 'z') {
                        out.write('a');
                    } else if (dictionary.containsKey(line.charAt(i))) {
                        int b = dictionary.get(line.charAt(i))+1;
                        out.write((char) b);
                    } else if (line.charAt(i) == ' ') {
                        out.write(' ');
                    } else {
                        int a = line.charAt(i) + 1;
                        out.write((char) a);
                    }
                }
            }
            System.out.println("A titkosított állomány "+filename+" néven elkészült!");
        } catch (IOException e) {
            System.out.println("Hiba történt!");
        }
        inFile.close();
        out.close();
    }
}
