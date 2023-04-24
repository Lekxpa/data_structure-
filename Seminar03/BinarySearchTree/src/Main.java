import com.sun.source.tree.Tree;

public class Main {
    public static void main(String[] args) {
//        Node first = new Node(100);
//        first.next = new Node(200);
//        first.next.next = new Node(300);
//        first.next.next.next = new Node(400);

        MyList li = new MyList();
        li.print();
        li.append(10);
        li.append(20);
        li.append(30);
        li.print();

//        print(first);
//        Node current = first;
//        while (current != null) {
//            System.out.println(current.value);
//            current = current.next;
//        }
    }
}
class Node{
    public int value;
    public Node next;
    public Node (int value){
        this.value = value;
        this.next = null;
    }
}

class MyList{
    Node head;
    public void append(int val){
//            Node n = new Node(val);
        if(this.head == null){
            this.head = new Node(val);
        }else{
//            Node n = new Node(val);
            Node current = this.head;
            while (current != null){
                if (current.next == null){
                    current.next = new Node(val);
                    break;
                }else{
                    current = current.next;
                }
            }
        }
    }


    public void print(){
        this.print(this.head);
    }
    static void print(Node current){
        if(current != null){
            System.out.println(current.value);
            print(current.next);
        }
    }
}


class TreeNode{
    int value;
    public TreeNode(int value){
        this.value = value;
    }
    TreeNode left;
    TreeNode right;
}
class BinarySearchTree{
    TreeNode root;
    public void append(int val){
        if(root == null){
            root = new TreeNode(val);
        }else{
            if(val > root.value){
                // строим правое поддерево
            }else{
                // строим левое поддерево
            }
        }
    }
}