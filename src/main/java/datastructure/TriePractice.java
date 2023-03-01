package datastructure;


/*
 * This is a trie practice question
 * question is
 * Given a list of words which are bad words
 * input string if it contains that word then return boolean result
 * */

import java.util.HashMap;
import java.util.Map;

/*
TrieCharNode is character trie
 */
class TrieCharNode {

    private Map<Character, TrieCharNode> children = new HashMap<>();

    private boolean isEndOfWord;

    public Map<Character, TrieCharNode> getChildren() {
        return children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

}

class Trie {
    /*
    Functions trie will have
    - void insert (String word)
    - boolean delete(String word)
    - boolean delete (TrieNode current, String word, int index)
    - boolean isEmpty ()
    - boolean containsNode (String word)
     */

    TrieCharNode root;

    public Trie() {
        root = new TrieCharNode();
    }

    void insert (String word){
        TrieCharNode current = root;
        for (char character: word.toCharArray()){

            current= current.getChildren().computeIfAbsent(character,c->new TrieCharNode());
        }
        current.setEndOfWord(true);
    }
    boolean isEmpty(){
        return root == null;
    }

    boolean delete(String word){
        return delete (root,word,0);
    }
    boolean delete (TrieCharNode current, String word, int index){
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieCharNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    

    }
}

public class TriePractice {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("bhaumik");
        System.out.println("This is a trie practice ");
    }
}
