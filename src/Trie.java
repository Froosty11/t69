import java.util.ArrayList;

public class Trie {
    public Trie[] next;
    public boolean word;

    String currentWord;
    public Trie(String s) {
        currentWord =s;
        next = new Trie[27];
        word = false;
    }
    public ArrayList<String> findAllWords(){
        ArrayList<String> allWords = new ArrayList<>();

        if(this.word){
            allWords.add(this.currentWord);
        }
        for (Trie node : next) {
            if (node != null) {
                allWords.addAll(node.findAllWords());
            }
        }

        return allWords;
    }
    public Trie findNode(String s){
        Trie current = this;
        char[] array = s.toCharArray();
        for (char c : array) {
            current = current.next[Helper.charTranslator(c)];
        }
        return current;
    }

}
