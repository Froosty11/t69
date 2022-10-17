public class Main {
    public static void main(String[] args) {
        Trie root = Helper.generateDictonary();
        System.out.println(
                Helper.intTranslator(20) + "" +
                        Helper.intTranslator(21) +
                        Helper.intTranslator(22));
        String input = "5 1 4";
        Trie temp = root.findNode(Helper.makeStringFromNumbers(input));
        System.out.println(temp.findAllWords());


    }
    /*
    "5 1 4 666"
    * */
}
