package avlthree;

public class Node {
    private long id;
    private Object element;
    private Node left;
    private Node right;
    private Node parent;
    private long b;

    public Node(long id, Object element, Node left, Node right) {
        this.id = id;
        this.element = element;
        this.left = left;
        this.right = right;
        this.b = 0;
        this.parent = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public long getB() {
        return b;
    }

    public void setB(long b) {
        this.b = b;
    }
}
