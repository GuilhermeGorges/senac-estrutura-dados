package binarytree;

public class Main {
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.insert(1,"A");
        binaryTree.insert(2, "B");
        binaryTree.insert(3, "C");
        binaryTree.insert(4, "D");
        binaryTree.insert(5, "E");
        binaryTree.insert(6, "H");
        binaryTree.insert(7, "I");
        binaryTree.insert(8, "J");
        binaryTree.insert(9, "K");
        binaryTree.insert(10, "L");

        binaryTree.printThreeElementsByPreFixed();
        binaryTree.printThreeElementsByPostFixed();
        binaryTree.printThreeElementsSymFixed();
        System.out.println();
        System.out.println(binaryTree.treeHeight());
    }
}
