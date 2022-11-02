package binarytree;

public class BinaryTree {

    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(long id, Object element) {
        Node newNode = new Node(id, element, null, null);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node currentNode = this.root;
            Node parentNode;

            while (true) {
                parentNode = currentNode;
                if (id < currentNode.getId()) {
                    currentNode = currentNode.getLeft();
                    if (currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if(currentNode == null) {
                        parentNode.setRight(newNode);
                        return;
                    }
                }

            }
        }
    }

    private void preFixed(Node current) {
        if (current != null) {
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
            preFixed(current.getLeft());
            preFixed(current.getRight());
        }
    }


    private void postFixed(Node current) {
        if (current != null) {
            postFixed(current.getLeft());
            postFixed(current.getRight());
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
        }
    }

    private void symFixed(Node current) {
        if (current != null) {
            symFixed(current.getLeft());
            System.out.println("Id: " + current.getId() + " Elemento: " + current.getElement());
            symFixed(current.getRight());
        }
    }

    public void printThreeElementsByPreFixed() {
        preFixed(this.root);
    }

    public void printThreeElementsByPostFixed() {
        postFixed(this.root);
    }

    public void printThreeElementsSymFixed() {
        symFixed(this.root);
    }

    private long heightCalculate(Node current, long height) {
        if (current != null) {
            long l,r;
            l = heightCalculate(current.getLeft(),height)+1;
            r = heightCalculate(current.getRight(),height)+1;
            if (l > r) {
                return height + l;
            } else {
                return height + r;
            }
        }
        return height;
    }

    public long treeHeight() {
        long height = 0;
        return heightCalculate(this.root, height);
    }
}


