import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
        }
            catch(IOException e){
                throw new RuntimeException(e);
            }

// second

//        RedBlackTree tree = new RedBlackTree();
//        tree.add(5);
//        tree.add(7);
//        tree.add(10);
//        tree.add(3);
//        tree.add(6);
//        tree.add(20);
//        tree.add(25);
//        tree.add(36);


//        next

//        RedBlackTree node = new RedBlackTree();
//        Scanner scan = new Scanner(System.in);
//
//        char ch;
//        do {
//            System.out.println("Enter a number");
//            int value = scan.nextInt();
//
//            node.add(value);
//            System.out.println("Whould you like to add some number? (y/n)");
//            ch = scan.next().charAt(0);
//        } while (ch == 'Y' || ch == 'y');
//    }
    }
}

