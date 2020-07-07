import java.util.ArrayList;
import java.util.HashMap;

public class TrieNode {

    char ch;
    HashMap<Character,TrieNode> subtree;
    boolean endOfTheWord;
    TrieNode parent;

    public TrieNode(){

        subtree = new HashMap<>();
        endOfTheWord = false;
    }
    public TrieNode(char ch){
        this();
        this.ch = ch;
    }
}
