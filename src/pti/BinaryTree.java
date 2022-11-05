package pti;

import binarytree.Node;

public class BinaryTree {

    private Node root;
    private long leftSideInsertCount = 0;
    private long rightSideInsertCount = 0;
    private long leftSide = 0;
    private long rightSide = 0;

    public long getLeftSide() {
        return leftSideInsertCount;
    }

    public long getRightSide() {
        return rightSideInsertCount;
    }

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
                        this.leftSideInsertCount = leftSideInsertCount + 1;
                        parentNode.setLeft(newNode);
                        return;
                    }
                } else {
                    currentNode = currentNode.getRight();
                    if(currentNode == null) {
                        this.rightSideInsertCount = rightSideInsertCount + 1;
                        parentNode.setRight(newNode);
                        return;
                    }
                }

            }
        }
    }

    private void sidesCounter(Node current, String side) {

        if ("I".equals(side)) {
            this.leftSide = 0;
            this.rightSide = 0;
        }

        if (current != null) {
            if ("L".equals(side)) {
                this.leftSide = this.leftSide + 1;
            } else if ("R".equals(side)) {
                this.rightSide = this.rightSide + 1;
            }
            sidesCounter(current.getLeft(), "L");
            sidesCounter(current.getRight(), "R");
        }

    }

    public long getLeftCount() {
        sidesCounter(this.root, "I");
        return this.leftSide;
    }
    public long getRightCount() {
        sidesCounter(this.root, "I");
        return this.rightSide;
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

}


