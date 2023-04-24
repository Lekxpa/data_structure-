
// односвязнный список
public class Main {
    Node head;
    Node tail;

// метод push - добавляет значение в начао очереди
    public void push(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    public Integer peek(){
        Integer result = null;
        if(tail != null){
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }


    // извлечение последнего элемента стека

    public Integer pop(){
        Integer result = null;
        if(head != null){
            result = head.value;
            head = head.next;
        }
        return result;
    }

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
        Node previous; // будет описывать предыдущее значение
    }
}