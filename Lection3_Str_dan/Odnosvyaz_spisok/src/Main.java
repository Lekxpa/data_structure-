
// односвязнный список
public class Main {
    Node head;
    // Node tail; односвязный список с конца обойти невозможно, у последней ноды нет ссылки на предыдущее значение


    // тк нет ссылки на предыдущий эл-т, используется рекурсия
    // разворот нужно запускать, если есть хотя бы 2 ноды
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
        // previousNode.next = null; либо перенесем в верхнюю функцию
    }


    public class Node{
        int value;
        Node next;

        // для двухсвязного списка добавляем еще одну переменную
        // Node previous; // будет описывать предыдущее значение
    }


}