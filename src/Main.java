import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Node root = new Node();
        try (BufferedReader br = new BufferedReader(new FileReader("src/kelly.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                Node current = root;
                System.out.println(line);
                for(char c : line.toCharArray()){
                    int i = charTranslator(c);
                    if(current.next[i] == null)
                    current.next[i] = new Node();
                    current = current.next[i];
                }
                current.word = true;
                System.out.println();

            }
        }
        catch (IOException fe) {
            System.out.println("File not found");
        }
        System.out.println("cock");
    }
    /*
    HELLO THIS IS DOCUMENTATION
    THIS TRANSLATES A CHAR TO A NUMBER CORRESPONDING
    IT SKIPS W, Q AND HAS ÄÅÖ
     */
    static int charTranslator(char c){
        int character = (int)c;
        if(character == 113) character++;
        if(character == 119) character++;
        System.out.println((char)character);
        character -= 97;
        if(character == 131) character = 24;
        if(character == 132) character = 25;
        if(character == 149) character = 26;
        return character;
    }

    /*
    "5 1 4 666"
    * */
}
