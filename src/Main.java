public class Main {
    public static void main(String[] args) {
        int iterations = 1;
        Trie root = new Trie(null);
        int[] nList = {100,100, 200, 500, 1000,4000, 8262};
        for (int n :
                nList) {
            long t_Start, t_Sum;
            t_Sum = 0;
            for(int i = 0; i < iterations; i++){
                t_Start = System.nanoTime();
                root = Helper.generateDictonary(n);
                t_Sum += System.nanoTime() - t_Start;
            }
            System.out.printf("%d\t%d\n", n, t_Sum/iterations);

        }

        String input = "6 66 555 444 555 3";
        Trie temp = root.findNode(Helper.makeStringFromNumbers(input));
        if(temp != null) System.out.println("Here are the possible words: " +temp.findAllWords());
        else System.out.println("Couldn't find input Node");


    }
    /*
    "5 1 4 666"
    * */
}
