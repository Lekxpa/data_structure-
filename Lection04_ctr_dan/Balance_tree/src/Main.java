import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        final RedBlackTree tree  = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (true){
                try {
                    int value = Integer.parseInt(reader.readLine());
                    tree.add(value);
                    System.out.println("finish");
                } catch (Exception ignored) {

                }
            }
            catch (IOException e){
                throw new RuntimeException(e);
            }
        }
    }

    private Node root;
    public boolean add(int value){
        if (root != null){
            boolean result = addNode(root, value);
            root = rebalance(root);
            root.color = Node.Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.color = Node.Color.BLACK;
            root.value = value;
            return true;
        }
    }
    public boolean addNode(Node node, int value){
        // если нода уже имеет такое значение  - ошибка, те создать новую Ноду нельзя
        if (node.value == value){
            return false;
        } else {
            // если значение Ноды больше искомого значения:
            // и левый ребенок существует:
            // запускаем рекурсивно поиск по левому ребенку вниз в глубину обходом с проверкой,
            // можно ли создать Ноду там
            // если можно - вернется какой-то результат
            if (node.value > value){
                if (node.leftChild != null){
                    boolean result = addNode(node.leftChild, value);
                    node.leftChild = rebalance(node.leftChild);
                    return result;
                }else{ // если левой ноды не существует, считаем, что нашли подходящее место
                    // для подстановки нашего значения, генерируем Ноду, присваиваем ей красный цвет
                    node.leftChild = new Node();
                    node.leftChild.color = Node.Color.RED;
                    node.leftChild.value = value;
                    return true;
                }
            }else{ // тоже самое для правого ребенка
                if(node.rigthChild != null) {
                    boolean result = addNode(node.rigthChild, value);
                    node.rigthChild = rebalance(node.rigthChild);
                    return result;
                }else{
                    node.rigthChild = new Node();
                    node.rigthChild.color = Node.Color.RED;
                    node.rigthChild.value = value;
                    return true;
                }
            }
        }
    }
    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rigthChild != null && result.rigthChild.color == Node.Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Node.Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Node.Color.RED &&
            result.leftChild.leftChild != null && result.leftChild.leftChild.color == Node.Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Node.Color.RED &&
            result.rigthChild != null && result.rigthChild.color == Node.Color.RED){
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }
    private Node leftSwap(Node node){
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rigthChild;
        leftChild.rigthChild = node;
        node.leftChild = betweenChild;
        leftChild.color =  node.color;
        node.color = Node.Color.RED;
        return leftChild;
    }
    private Node rightSwap(Node node){
        Node rigthChild = node.rigthChild;
        Node betweenChild = rigthChild.leftChild;
        rigthChild.leftChild = node;
        node.rigthChild = betweenChild;
        rigthChild.color =  node.color;
        node.color = Node.Color.RED;
        return rigthChild;
    }

    private void colorSwap(Node node){
        node.rigthChild.color = Node.Color.BLACK;
        node.leftChild.color = Node.Color.BLACK;
        node.color = Node.Color.RED;
    }


    private class Node{
        private int value;
        private Color color;
        private Node leftChild;
        private Node rigthChild;
        @Override
        public String toString(){
            return "Node{" +
                    "value=" + value +
                    ", color= " + color +
                    "}";
        }
        private enum Color {
            RED, BLACK;
        }
    }
}