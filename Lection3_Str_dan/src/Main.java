
// связнный список
public class Main {
    Node head;
    Node tail; // добавили ссылку на последний элемент

    // вставка в конец списка:
    public void add(int value){
        Node node = new Node();
        // заполняем новую ноду данными
        node.value = value;
        // проверим, есть ли в нашем списки элементы, или это первая нода:
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    //вставка в середину списка:
    public void add(int value, Node node){
        // создаем ссылки
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        // далее берем текущую ноду и говорим, что это новая нода:
        node.next = newNode;
        newNode.previous = node; // предыдущий эл-т в наст.момет - нода
        if (next == null){
            tail = newNode;
        }else{
            next.previous = newNode;
            newNode.next = next;
        }
    }

    //удаление ноды
    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;
        // если список пустой:
        if(previous == null){
            next.previous = null;
            head = next;
        } else { // удаляем последний элемент
            if (next == null) {
                previous.next = null;
                tail = previous;
            } else {
                //когда нода находится в середине списка:
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    // разворот двусвязного списка
    public void revert(){
        Node currentNode = head;
        while (currentNode != null){
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if(previous == null){
                tail = currentNode;
            }
            if(next == null){
                //.т.е. последний элемент
                head = currentNode;
            }
            currentNode = next;
        }
    }

    // поиск элемента
    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if(currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }
    public class Node{
        int value;
        Node next;

        // для двухсвязного списка добавляем еще одну переменную
        Node previous; // будет описывать предыдущее значение
    }


}