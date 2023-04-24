import java.util.ArrayList;
import java.util.List;
// обход в глубину
public class Main {

    public class Tree{
        Node root;
        public boolean exist(int value){
            if(root != null) {
                Node node = find(root, value);
                if (node != null) {
                    return true;
                }
            }
            return  false;
        }
    private Node find(int value){
            // заводим список Текущая линия
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0){
            List <Node> nextLine = new ArrayList<>();
            for (Node node : line){
                if (node.value == value){
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }
        public class Node{
            int value;
            List<Node> children;

        }
    }
    public static void main(String[] args) {

    }
}