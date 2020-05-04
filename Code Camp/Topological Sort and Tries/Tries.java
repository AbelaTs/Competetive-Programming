import java.util.HashMap;
import java.util.Scanner;

class TrieNode {
    HashMap<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
        isEndOfWord = false;
    }
}

public class Tries {
    TrieNode root;

    public Tries() {
        root = new TrieNode();
    }

    public void insert(String s) {
        TrieNode current = root;
        for (int index = 0; index < s.length(); index++) {
            char cr = s.charAt(index);
            if (!current.children.containsKey(cr)) {
                current.children.put(cr, new TrieNode());
            }
            current = current.children.get(cr);
        }
        current.isEndOfWord = true;

    }

    public boolean search(String s) {
        TrieNode current = root;
        for (int index = 0; index < s.length(); index++) {
            char letter = s.charAt(index);
            if (current.children.containsKey(letter)) {
                current = current.children.get(letter);
            } else {
                return false;
            }
        }
        return current.isEndOfWord;
    }

    public boolean delete(String s) {
        TrieNode current = root;
        return delete(s, 0, current);
    }

    public boolean delete(String s, int index, TrieNode root) {
        if (index == s.length()) {
            if (!root.isEndOfWord) {
                return false;
            }
            root.isEndOfWord = false;
            return root.children.size() == 0;
        }
        char letter = s.charAt(index);

        if (root.children.containsKey(letter)) {
            root = root.children.get(letter);
        } else {
            return false;
        }

        boolean shouldDeleteNode = delete(s, index + 1, root);
        if (shouldDeleteNode) {
            System.out.println(letter);
            root.children.remove(root.children.remove(letter));
            return root.children.size() == 0;
        } else {

            root.isEndOfWord = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.insert("Abel");
        tries.insert("Zekidus");
        tries.insert("Beza");

        System.out.println(tries.search("Zekidu"));

    }
}