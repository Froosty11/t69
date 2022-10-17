import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
    /**
     * Returns full dictonary of swedish words. Root contains 27 letters that are the start for each word
     * @return root of the tree
     */
    public static Trie generateDictonary(){
        Trie root = new Trie("");
        try (BufferedReader br = new BufferedReader(new FileReader("src/kelly.txt"))){
            String line = "";
            while((line = br.readLine()) != null){
                Trie current = root;
                System.out.println(line);
                for(char c : line.toCharArray()){
                    int i = charTranslator(c);
                    if(current.next[i] == null)
                        current.next[i] = new Trie(current.currentWord + c);
                    current = current.next[i];
                }
                current.word = true;
                System.out.println();
            }
        }
        catch (IOException fe) {
            System.out.println("File not found");
        }
        return root;
    }

    /**
     *
     * @param i
     * @return
     */
    static char intTranslator(int i){
        char c = '0';
        c = (char)(i+97);
        if(i >= 16) c++;
        if(i >= 21) c++;
        if(i == 24) c = 'ä';
        if(i == 25) c = 'å';
        if(i == 26) c = 'ö';
        return c;
    }
    public static int charTranslator(char c){
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
    public static String makeStringFromNumbers(String s){
        String[] array = s.split(" ");
        String st = "";
        for (String section : array) {
            int code = 3* Integer.parseInt(String.valueOf(section.toCharArray()[0]));
            code += section.length()- 4;
            st+= Helper.intTranslator(code);
        }
        return st;
    }
}
