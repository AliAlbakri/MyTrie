# MyTrie
The project represents a Trie data structure. It is a Trie of uppercase alphabetical letters. A trie is a data structure that permits efficient lookup of words in a dictionary. It supports the following operations:
(a) contains(String s) [return type boolean] = true if the word ‘s’ is contained in the trie. 
(b) isPrefix(String p) [return type boolean] = true if ‘p’ is a prefix of any word in the trie. 
(c) insert(String s) [return type void] = inserts the word ‘s’ in the trie. 
(d) delete(String s) [return type void] = deletes ‘s’ from the trie. 
(e) isEmpty() [return type boolean] 
(f) clear() [return type void] 
(g) constructors, accessors, mutators = as needed 
(h) allWordsPrefix(String
p) [return type String[]] = this method returns all words whose prefix is ‘p’.
(i) size() [return type int] = returns the number of nodes in the trie.


Initially your program will take from the user a list of letters (or a word). It will then make all arrangements of the letters in this word and insert them in the trie if these are valid words from the dictionary. This procedure is to be done only the first time (initially).
