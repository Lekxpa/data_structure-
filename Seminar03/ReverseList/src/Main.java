public class Main {
    public static void main(String[] args) {
        MyList li = new MyList();
        li.append(1);
        li.append(2);
        li.append(3);
        li.append(4);
        li.append(5);
        li.print();
        System.out.println("Revert: ");
        li.revert();
        li.print();
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
        if(this.head == null){
            this.head = new Node(val);
        }else{
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
    public void revert(){
        if(head != null && head.next != null){
            Node temp = head;
            revert(head.next, head);
            temp.next = null;
        }
    }
    private void revert(Node currentNode, Node previousNode){
        if(currentNode.next == null){
            head = currentNode;
        }else{
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }
}