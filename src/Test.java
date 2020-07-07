import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String []args){


        Scanner input = new Scanner(System.in);





        boolean repeat = true;
        System.out.println("TRIE PROJECT: Enter your choice?\n" +
                "1) Create an empty trie\n" +
                "2) Insert a word\n" +
                "3) Delete a word\n" +
                "4) List all words that begin with a prefix\n" +
                "5) Size of the trie\n" +
                "6) End\n");
        Trie myTire = new Trie();

        do{


            String option = input.next();

            switch (option){


                case "1" :
                    System.out.println("your empty trie has been already created");
                    myTire.clear();
                    break;

                case "2":
                    System.out.println("Enter your list of letters>");
                    option = input.next();
                    myTire.insert(option);
                    System.out.println("Word Inserted");
                    break;


                case"3":
                    System.out.println("Enter a word to be deleted");
                    option = input.next();
                    myTire.delete(option);



                    break;



                case "4": System.out.println("Enter a prefix");

                         option = input.next();
                         String [] words = myTire.allWordsPrefix(option);

                    for(String s :words)
                        System.out.println(s);

                    break;
                case "5":
                    System.out.println("the size of the trie = "+myTire.size());
                    break;



                case"6":
                    repeat = false;
                    break;


                default:
                    System.out.println("enter a correct choice");


            }


        }while(repeat);







    }
}
