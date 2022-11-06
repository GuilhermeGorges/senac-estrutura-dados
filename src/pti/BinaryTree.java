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

    // Impressão da árvore com as arestas.
    // Surgimento de anomalias na impressão com árvores com mais de 6 nós
    String[][] matrix;
    int x, y;
    int yAdjusted;
    private void populateMatrixByTree(Node current, String side) {
        if ("I".equals(side)) {
            int threeHeight = heightCalculate(this.root, 0);
            matrix = new String[(threeHeight * 2)][(threeHeight * 14)];
            int matrixLengthY = matrix[0].length;

            matrix[0][Math.round(matrixLengthY / 2)] = current.getElement().toString();
            y = Math.round(matrixLengthY / 2);
            x = 0;
        }
        if (current != null) {
            if ("L".equals(side)) {
                y-=3;
                yAdjusted =  y + adjustDistortion(x, y);
                System.out.println("L");
                System.out.println(y);
                System.out.println(yAdjusted);
                matrix[x-1][yAdjusted+1] = "  /  ";
                matrix[x][yAdjusted] = current.getElement().toString();
            } else if ("R".equals(side)) {
                y+=3;
                yAdjusted =  y - adjustDistortion(x, y);
                System.out.println("R");
                System.out.println(y);
                System.out.println(yAdjusted);
                matrix[x-1][yAdjusted-1] = "  \\  ";
                matrix[x][yAdjusted] = current.getElement().toString();
            }
            x+=2;
            populateMatrixByTree(current.getLeft(), "L");
            y+=3;
            populateMatrixByTree(current.getRight(), "R");
            y-=3;
            x-=2;
        }
    }

    //Tentativa de ajuste da distorção sem sucesso
    private int adjustDistortion (int x, int y) {
//        if (y<25) {
//            x = (int) (x / 3);
//        } else if (y <= 35 && x <= 6) {
//            x = (int) (x / 2);
//        }
        return x = (int) (x / 3);
    }

    public void printTreeByMatrix() {
        populateMatrixByTree(this.root, "I");
        for (int x = 0; x < matrix.length; x++) {
            System.out.print(x+" ");
            for (int y = 0; y < matrix[x].length; y++) {
                if (matrix[x][y] != null) {
                    System.out.print( matrix[x][y]);
                } else {
                    System.out.print(" --- ");
                }
            }
            System.out.println();
        }

    }

    private int heightCalculate(Node current, int height) {
        if (current != null) {
            int l,r;
            l = heightCalculate(current.getLeft(),height) + 1;
            r = heightCalculate(current.getRight(),height) + 1;
            if (l > r) {
                return height + l;
            } else {
                return height + r;
            }
        }
        return height;
    }
}


