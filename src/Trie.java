import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.*;

public class Trie {

    public TrieNode root;
    private int size;
    ArrayList<String> words;
    TrieNode prefixRoot;
    String curPrefix;


    public Trie(){
        root = new TrieNode();
        words  = new ArrayList<String>();
        size=0;
    }


    public int size(){
        return size;
    }
    public void clear(){
        root.subtree.clear();
        size = 0;
    }

    public boolean isEmpty(){
        return root.subtree.size()==0;
    }




    public void insert(String s){
        s = s.toUpperCase();
        TrieNode curr = root;

        for(int i =0;i<s.length();i++){

            char c = s.charAt(i);
            TrieNode tempNode = curr.subtree.get(c);// if it is null, that's mean the letter is not there
            if(tempNode==null){
                tempNode = new TrieNode(c);
                tempNode.parent = curr;
                curr.subtree.put(c,tempNode);
                size++;
            }
            curr = tempNode;

        }
        curr.endOfTheWord =true;


    }


    public boolean contains(String s) {
            s =s.toUpperCase();
        TrieNode curr = root;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            TrieNode tempNode = curr.subtree.get(c);// if it is null, that's mean the letter is not there, and thus the word not there
            if (tempNode == null)
                return false;
            curr = tempNode;
        }

        return curr.endOfTheWord; // here it might be the word exist but it is not a compelete word.

    }

    /*
    public boolean isPrefix(String p){
        return !contains(p);

    }

     */



    public TrieNode mylocation(String p) {
        p = p.toUpperCase();
        if (!isPrefix(p)) {
            return null;

        } else {
            TrieNode curr = root;
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                curr = curr.subtree.get(c);
            }
            return curr;
        }
    }


    public void delete(String s){
        boolean de= deleteWord(root,s.toUpperCase(),0);
        if (!de)
            System.out.println("no such word");
        else{
            System.out.println("Word Deleted");
        }
    }

    private boolean deleteWord(TrieNode curr,String s , int index){
        if(s.length()==index){
            // checks that if the word is complete&valid word or not
            if(!curr.endOfTheWord){
                return false;
            }
            curr.endOfTheWord = false;

            //if the statement is true, then we we deal with this and delete it, since no other nodes build on top of it.
            return curr.subtree.size()==0;

        }

        char c = s.charAt(index);
        TrieNode temp = curr.subtree.get(c);
        // if null, this means that the nodes does't exist, hence the word is not in the trie
        if(temp==null){
            return false;
        }
        //keep recursivly traversing s until we reach the end of the word 's'.
        boolean toBeDeletedNode = deleteWord(temp,s,index+1);


        if(toBeDeletedNode){
            //removing the key of the node.
            curr.subtree.remove(c);
            curr.ch = ' ';
            size--;

            //removing the refrence as well
            return curr.subtree.size()==0;
        }

        return false;
    }

    /**********************/













    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean isPrefix(String prefix)
    {
        if(searchNode(prefix) == null) {return false;}
        else{return true;}
    }

    public TrieNode searchNode(String str)
    {
        str = str.toUpperCase();
        Map<Character, TrieNode> children = root.subtree;
        TrieNode t = null;
        for(int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            if(children.containsKey(c))
            {
                t = children.get(c);
                children = t.subtree;
            }
            else{return null;}
        }

        prefixRoot = t;
        curPrefix = str;
        words.clear();
        return t;
    }


    public String[] allWordsPrefix(String p){
        p = p.toUpperCase();
        if(!isPrefix(p)){
            String[] empty = new String[1];
            empty[0] = "no such word";
            return empty;
        }
        TrieNode pre = searchNode(p);
        wordsFinderTraversal(pre,0);
        String[] allWords = new String[words.size()];
        allWords = words.toArray(allWords);
        return allWords;

    }


    ///////////////////////////


    void wordsFinderTraversal(TrieNode node, int offset)
    {
        //  print(node, offset);

        if(node.endOfTheWord==true)
        {
            //println("leaf node found");

            TrieNode altair;
            altair = node;

            Stack<String> hstack = new Stack<String>();

            while(altair != prefixRoot)
            {
                //println(altair.c);
                hstack.push( Character.toString(altair.ch) );
                altair = altair.parent;
            }

            String wrd = curPrefix;

            while(hstack.empty()==false)
            {
                wrd = wrd + hstack.pop();
            }

            //println(wrd);
            words.add(wrd);

        }

        Set<Character> kset = node.subtree.keySet();
        //println(node.c); println(node.isLeaf);println(kset);
        Iterator itr = kset.iterator();
        ArrayList<Character> aloc = new ArrayList<Character>();

        while(itr.hasNext())
        {
            Character ch = (Character)itr.next();
            aloc.add(ch);
            //println(ch);
        }

        // here you can play with the order of the children

        for( int i=0;i<aloc.size();i++)
        {
            wordsFinderTraversal(node.subtree.get(aloc.get(i)), offset + 2);
        }

    }


    void displayFoundWords()
    {
        System.out.println("_______________");
        for(int i=0;i<words.size();i++)
        {
            System.out.println(words.get(i));
        }
        System.out.println("________________");

    }






}



