package pti;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;
    private long leftSideCounter = 0;
    private long rightSideCounter = 0;

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
                        parentNode.setLeft(newNode);
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

    private void sidesCounter(Node current, String side) {
        if ("I".equals(side)) {
            this.leftSideCounter = 0;
            this.rightSideCounter = 0;
        }
        if (current != null) {
            if ("L".equals(side)) {
                this.leftSideCounter = this.leftSideCounter + 1;
            } else if ("R".equals(side)) {
                this.rightSideCounter = this.rightSideCounter + 1;
            }
            sidesCounter(current.getLeft(), "L");
            sidesCounter(current.getRight(), "R");
        }
    }

    public long getLeftCount() {
        sidesCounter(this.root, "I");
        return this.leftSideCounter;
    }

    public long getRightCount() {
        sidesCounter(this.root, "I");
        return this.rightSideCounter;
    }

    private void preFixedIndentingByDepth(Node current, String spaces) {
        if (current != null) {
            System.out.println(spaces + current.getId());
            preFixedIndentingByDepth(current.getLeft(), spaces.concat("   "));
            preFixedIndentingByDepth(current.getRight(), spaces.concat("   "));
            spaces.replace("   ", "");
        } else {
            System.out.println(spaces + "-");
        }
    }

    public void printThreeElementsByIndentingByDepth() {
        preFixedIndentingByDepth(this.root, "");
    }

    // Testando implementação para impressão da árvore com as arestas.

    List<String> spaces = new ArrayList<>();
    private void pintTree(Node current, String side) {
        if ("I".equals(side)) {
            for (int i = 0; i < 10; i++) {
                spaces.add("  ");
            }
            printSpaces(spaces);
            System.out.println(current.getId());
        }
        if (current != null) {
            if ("L".equals(side)) {
                printSpaces(spaces);
                System.out.println("/");
                spaces.remove(0);
                printSpaces(spaces);
                System.out.println(current.getId());
            } else if ("R".equals(side)) {
                printSpaces(spaces);
                System.out.println("\\");
                spaces.add("  ");
                printSpaces(spaces);
                System.out.println(current.getId());
            }
            pintTree(current.getLeft(), "L");
            pintTree(current.getRight(), "R");
        }
    }

    private void printSpaces(List<String> spaces) {
        spaces.forEach(System.out::print);
    }

    public void printTree() {
        pintTree(this.root, "I");
    }

}


