package binarysearchthree;

import binarytree.Node;

public class BinarySearchThree {

    private Node root;

    public BinarySearchThree() {
        this.root = null;
    }

    public void insertBST(long id, Object element) {
        if (this.root == null) {
            this.root = new Node(id, element,null,null);
        } else {
            Node newNode = new Node(id, element, null,null);
            insert(this.root, newNode);
        }
    }

    public Node bstSearch(long id) {
        return search(this.root, id);
    }

    public void printThreeElementsByPreFixed() {
        preFixed(this.root);
    }

    public void printThreeElementsByPostFixed() {
        postFixed(this.root);
    }

    public void printThreeElementsBySymFixed() {
        symFixed(this.root);
    }

    private void insert(Node current, Node newNode) {
        if (current.getId() == newNode.getId()) {
        }

        if (newNode.getId() < current.getId()) {
            if(current.getLeft() == null) {
                current.setLeft(newNode);
            } else {
                insert(current.getLeft(), newNode);
            }
        }

        if (newNode.getId() > current.getId()) {
            if(current.getRight() == null) {
                current.setRight(newNode);
            } else {
                insert(current.getRight(), newNode);
            }
        }
    }

    private Node search(Node current, long id) {
        if (current == null) {
            return null;
        } else {
            if (id == current.getId()) {
                return current;
            } else {
                if (id < current.getId()) {
                    return search(current.getLeft(), id);
                } else {
                    return search(current.getRight(), id);
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
}
