import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    public Node addFromArray(int[] array) {
        for(int i=0;i<array.length;i++) {
            Node newNode = new Node(array[i]);
            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                Node parent;
                while (true) {
                    parent = current;
                    if (array[i] < current.key) {
                        current = current.left;
                        if (current == null) {
                            parent.left = newNode;
                            break;
                        }
                    } else {
                        current = current.right;
                        if (current == null) {
                            parent.right = newNode;
                            break;
                        }
                    }
                }
            }
        }
        return root;
    }

    private Node search(Node current, int key){
    if ((current==null) || (current.key==key)){
        return current;
    }
    if(key<current.key){
        return search(current.left,key);
    }
    else return search(current.right,key);
    }

    public void inOrderTraverse(Node current){
        if(current!=null){
            inOrderTraverse(current.left);
            System.out.print(current.key+" ");
            inOrderTraverse(current.right);
        }
    }
    public void preOrderTraverse(Node current){
        if(current!=null){
            System.out.print(current.key+" ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void postOrderTraverse(Node current){
        if(current!=null){
            postOrderTraverse(current.left);
            postOrderTraverse(current.right);
            System.out.print(current.key+" ");
        }
    }

    public static int calculateHeight(Node root) {
        if (root == null)
            return 0;
        int heightLeft = calculateHeight(root.left);
        int heightRight = calculateHeight(root.right);
        return Math.max(heightLeft, heightRight) + 1;
    }

    public void bfs(){
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        while (!nodes.isEmpty())
        {
            Node tmpNode = nodes.poll();
            System.out.print(tmpNode.key + " ");
            if (tmpNode.left != null) {
                nodes.add(tmpNode.left);
            }
            if (tmpNode.right != null) {
                nodes.add(tmpNode.right);
            }
        }
    }
}
