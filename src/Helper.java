import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Helper {
    /**
     * Returns full dictonary of swedish words. Root contains 27 letters that are the start for each word
     * @return root of the tree
     */
    public static Trie generateDictonary(int n){
        Trie root = new Trie("");
        int f = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("src/kelly.txt"))){
            String line = "";
            if(n == -1 ) n = 8264;
            while(((line = br.readLine()) != null) && n-- > 0){
                Trie current = root;
                f++;
                System.out.println(line);
                for(char c : line.toCharArray()){
                    int i = charTranslator(c);
                    if(current.next[i] == null)
                        current.next[i] = new Trie(current.currentWord + c);
                    current = current.next[i];
                }
                current.word = true;
            }
        }
        catch (IOException fe) {
            System.out.println("File not found");
        }
        return root;
    }

    /**
     *Translates an integer to a char using 0-26 ints
     * @param i input int. 0-26 where each number represents a letter a-ö
     * @return a-ö but not q or w
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

    /**
     * Returns our Index-based value for the character input
     * @param c input character- needs to be a-ö but not w or q.
     * @return returns a number between 0-26 that represents the index'
     */
    public static int charTranslator(char c){
        int character = (int)c;
        if(character == 113) character++;
        if(character == 119) character++;
        //System.out.println((char)character);
        character -= 97;
        if(character == 131) character = 24;
        if(character == 132) character = 25;
        if(character == 149) character = 26;
        return character;
    }

    /**
     * M
     * @param s
     * @return
     */
    public static String makeStringFromNumbers(String s){
        char[] charArray = s.toCharArray();
        for(int i = 0; i <charArray.length-1; i++ ){
            if((charArray[i] != charArray[i+1] && charArray[i+1] != 32) && (charArray[i] != 32))
                System.out.println("Wrong input format!");
        }
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
